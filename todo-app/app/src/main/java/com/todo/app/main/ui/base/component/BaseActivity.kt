package com.todo.app.main.ui.base.component

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import androidx.annotation.CallSuper
import androidx.annotation.ColorRes
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelProviders
import com.todo.app.R
import com.todo.app.main.ui.base.callback.MvpView
import com.todo.app.main.ui.base.makeItGone
import com.todo.app.main.ui.base.makeItInvisible
import com.todo.app.main.ui.base.makeItVisible
import com.todo.app.main.ui.base.setRipple
import com.todo.app.utils.helper.LanguageUtils
import com.todo.app.utils.helper.ViewUtils
import com.todo.app.utils.helper.imagepicker.ImagePickerUtils
import com.todo.app.utils.libs.ImageCropperUtils

/**
 * This is base activity class which will be extended for creating next activities
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
abstract class BaseActivity<V : MvpView, P : BasePresenter<V>>(
    private val presenterClass: Class<P>,
    @LayoutRes private val layoutResourceID: Int
) : AppCompatActivity(), MvpView, View.OnClickListener, View.OnFocusChangeListener {

    /**
     * LifecycleRegistry is an implementation of Lifecycle that can handle multiple observers.
     * It is used by Fragments and Support Library Activities.
     * You can also directly use it if you have a custom LifecycleOwner.
     */
    private val mLifecycleRegistry = LifecycleRegistry(this)

    /**
     * Fields
     * */
    protected var menu: Menu? = null
        private set
    protected var currentFragment: BaseFragment<*, *>? = null
        private set
    protected lateinit var presenter: P

    // This method is called when activity initialization gets completed
    protected abstract fun createUI()

    // This method is called when activity gets destroyed
    protected abstract fun destroyUI()

    /**
     * Optional to be overridden methods
     * */
    // Child class will pass the status bar color resource id by this method
    @ColorRes
    protected open fun getStatusBarColorResId(): Int {
        return INVALID_ID
    }

    // Child class will pass the toolbar id by this method
    @IdRes
    protected open fun getToolbarId(): Int? {
        return INVALID_ID
    }

    // This method sets if the back icon should be shown or not at toolbar
    protected open fun shouldShowBackIconAtToolbar(): Boolean {
        return true
    }

    // Child class will pass the menu id by this method
    protected open fun getMenuId(): Int {
        return INVALID_ID
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LanguageUtils.onAttach(newBase!!))
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (layoutResourceID > INVALID_ID) {
            initializeLayout()
        }

        initializePresenter()
        initializeToolbar()
        initializeStatusBar()

        this.createUI()
    }

    /**
     * This method initializes activity presenter
     * */
    @Suppress("UNCHECKED_CAST")
    private fun initializePresenter() {
        val viewModel = ViewModelProviders.of(this)
            .get(BaseViewModel<V, P>().javaClass)
        var isPresenterCreated = false

        if (viewModel.getPresenter() == null) {
            viewModel.setPresenter(presenterClass.newInstance())
            isPresenterCreated = true
        }

        presenter = viewModel.getPresenter()!!
        presenter.attachLifecycle(mLifecycleRegistry)
        presenter.attachView(this as V)

        if (isPresenterCreated) {
            presenter.onPresenterCreated()
        }

        presenter.activity = this
    }

    /**
     * This method initializes the layout to the activity
     * */
    private fun initializeLayout() {
        setContentView(layoutResourceID)
    }

    /**
     * This method initializes the toolbar
     * */
    private fun initializeToolbar() {
        if (getToolbarId() != INVALID_ID) {
            setSupportActionBar(findViewById(getToolbarId()!!))

            if (shouldShowBackIconAtToolbar()) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setDisplayShowHomeEnabled(true)
            }
        }
    }

    /**
     * This method initializes the status bar
     * */
    private fun initializeStatusBar() {
        val statusBarColorResId = getStatusBarColorResId()

        if (statusBarColorResId > INVALID_ID) {
            ViewUtils.setStatusBarColor(this, statusBarColorResId)
        }
    }

    protected fun showProgress() {
        findViewById<ProgressBar>(R.id.progress_bar)?.makeItVisible()
        findViewById<ConstraintLayout>(R.id.constraint_layout_main_container)?.makeItGone()
    }

    protected fun hideProgress() {
        findViewById<ProgressBar>(R.id.progress_bar)?.makeItGone()
        findViewById<ConstraintLayout>(R.id.constraint_layout_main_container)?.makeItVisible()
    }

    /**
     * This method sets ripple to multiple views
     *
     * @param views multiple views
     * */
    protected fun setRipple(vararg views: View) {
        for (view in views) {
            view.setRipple(R.color.colorPrimary26)
        }
    }

    /**
     * This method makes multiple views visible
     *
     * @param views multiple views
     * */
    protected fun makeThemVisible(vararg views: View) {
        for (view in views) {
            view.makeItVisible()
        }
    }

    /**
     * This method makes multiple views gone
     *
     * @param views multiple views
     * */
    protected fun makeThemGone(vararg views: View) {
        for (view in views) {
            view.makeItGone()
        }
    }

    /**
     * This method makes multiple views invisible
     *
     * @param views multiple views
     * */
    protected fun makeThemInvisible(vararg views: View) {
        for (view in views) {
            view.makeItInvisible()
        }
    }

    override fun onClick(view: View) {

    }

    override fun onFocusChange(view: View, hasFocus: Boolean) {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (getMenuId() > INVALID_ID) {
            menuInflater.inflate(getMenuId(), menu)
            this.menu = menu
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onStop() {
        super.onStop()
        presenter.compositeDisposable.clear()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        ImagePickerUtils.onActivityResult(this, requestCode, resultCode, data)
        ImageCropperUtils.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroy() {
        super.onDestroy()
        this.destroyUI()

        presenter.detachLifecycle(mLifecycleRegistry)
        presenter.detachView()
    }

    /**
     * This method sets title of the toolbar
     *
     * @param title toolbar title
     * */
    fun setTitle(title: String) {
        supportActionBar?.title = title
    }

    /**
     * This method sets subtitle of the toolbar
     *
     * @param subtitle toolbar subtitle
     * */
    fun setSubtitle(subtitle: String) {
        supportActionBar?.subtitle = subtitle
    }

    /**
     * This method sets both title and subtitle of toolbar
     *
     * @param title    toolbar title
     * @param subtitle toolbar subtitle
     * */
    fun setToolbarText(title: String, subtitle: String) {
        setTitle(title)
        setSubtitle(subtitle)
    }

    /**
     * This method sets click listener to multiple views
     *
     * @param views multiple views
     * */
    protected fun setClickListener(vararg views: View) {
        for (view in views) {
            view.setOnClickListener(this)
        }
    }

    /**
     * This method sets animation to multiple views
     *
     * @param animationResourceId resource id of an animation
     * @param views multiple views
     * */
    protected fun setAnimation(animationResourceId: Int, vararg views: View) {
        val animation = AnimationUtils.loadAnimation(this, animationResourceId)

        for (view in views) {
            view.startAnimation(animation)
        }
    }

    /**
     * This method starts a fragment
     *
     * @param viewId       int value
     * @param baseFragment fragment object
     * */
    protected fun commitFragment(viewId: Int, baseFragment: BaseFragment<*, *>) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(viewId, baseFragment, baseFragment.javaClass.name)
            .commit()

        currentFragment = baseFragment
    }

    companion object {
        const val INVALID_ID = -1

        /**
         * This method runs current activity
         *
         * @param context UI context
         * @param intent intent for current activity
         * */
        fun runCurrentActivity(context: Context, intent: Intent) {
            context.startActivity(intent)
        }
    }
}
