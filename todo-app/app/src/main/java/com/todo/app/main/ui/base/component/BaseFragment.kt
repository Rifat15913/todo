package com.todo.app.main.ui.base.component

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelProviders
import com.todo.app.R
import com.todo.app.main.ui.base.callback.MvpView
import com.todo.app.main.ui.base.makeItGone
import com.todo.app.main.ui.base.makeItInvisible
import com.todo.app.main.ui.base.makeItVisible
import com.todo.app.main.ui.base.setRipple
import com.todo.app.utils.helper.imagepicker.ImagePickerUtils
import com.todo.app.utils.libs.ImageCropperUtils

/**
 * This is base fragment class which will be extended for creating next fragments
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
abstract class BaseFragment<V : MvpView, P : BasePresenter<V>>(
    private val presenterClass: Class<P>,
    @LayoutRes private val layoutResourceID: Int
) : Fragment(), MvpView, View.OnClickListener {

    /**
     * LifecycleRegistry is an implementation of Lifecycle that can handle multiple observers.
     * It is used by Fragments and Support Library Activities.
     * You can also directly use it if you have a custom LifecycleOwner.
     */
    private val mLifecycleRegistry = LifecycleRegistry(this)

    /**
     * Fields
     * */
    var currentChildFragment: BaseFragment<*, *>? = null
        private set

    protected lateinit var presenter: P

    // This fragment context
    protected lateinit var mContext: Context

    // This method is called when activity initialization gets completed
    protected abstract fun createUI()

    // This method is called when activity gets destroyed
    protected abstract fun destroyUI()

    /**
     * Optional to be overridden methods
     * */
    // Child class will pass the menu id by this method
    protected open fun getMenuId(): Int {
        return INVALID_ID
    }

    @Suppress("UNCHECKED_CAST")
    protected val baseActivity: BaseActivity<*, *>?
        get() = activity as BaseActivity<*, *>?

    private val isBaseActivityInstance: Boolean
        get() = BaseActivity::class.java.isInstance(activity)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (getMenuId() > INVALID_ID) {
            setHasOptionsMenu(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (getMenuId() > INVALID_ID) {
            inflater.inflate(getMenuId(), menu)
            super.onCreateOptionsMenu(menu, inflater)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return if (layoutResourceID > INVALID_ID) {
            initializeLayout(inflater, layoutResourceID, container)
        } else {
            super.onCreateView(inflater, container, savedInstanceState)
        }
    }

    /**
     * This method initializes the layout to the fragment
     *
     * @param inflater to inflate the layout
     * @param layoutResourceID id of the layout
     * @param container ViewGroup of the layout
     * @return [View] inflated layout view
     * */
    private fun initializeLayout(
        inflater: LayoutInflater,
        layoutResourceID: Int,
        container: ViewGroup?
    ): View? {
        return inflater.inflate(layoutResourceID, container, false)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializePresenter()
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

        presenter.activity = activity
    }

    override fun onClick(view: View) {

    }

    protected fun showProgress() {
        view?.findViewById<ProgressBar>(R.id.progress_bar)?.makeItVisible()
        view?.findViewById<ConstraintLayout>(R.id.constraint_layout_main_container)?.makeItGone()
    }

    protected fun hideProgress() {
        view?.findViewById<ProgressBar>(R.id.progress_bar)?.makeItGone()
        view?.findViewById<ConstraintLayout>(R.id.constraint_layout_main_container)?.makeItVisible()
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
        if (isBaseActivityInstance) {
            baseActivity?.setTitle(title)
        }
    }

    /**
     * This method sets subtitle of the toolbar
     *
     * @param subtitle toolbar subtitle
     * */
    fun setSubtitle(subtitle: String) {
        if (isBaseActivityInstance) {
            baseActivity?.setSubtitle(subtitle)
        }
    }

    /**
     * This method sets both title and subtitle of toolbar
     *
     * @param title    toolbar title
     * @param subtitle toolbar subtitle
     * */
    fun setToolbarText(title: String, subtitle: String) {
        if (isBaseActivityInstance) {
            baseActivity?.setToolbarText(title, subtitle)
        }
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

    /**
     * This method sets animation to multiple views
     *
     * @param animationResourceId resource id of an animation
     * @param views multiple views
     * */
    protected fun setAnimation(animationResourceId: Int, vararg views: View) {
        if (context != null) {
            val animation = AnimationUtils.loadAnimation(context, animationResourceId)

            for (view in views) {
                view.startAnimation(animation)
            }
        }
    }

    /**
     * This method starts a child fragment
     *
     * @param viewId       int value
     * @param baseFragment fragment object
     * */
    protected fun commitChildFragment(viewId: Int, baseFragment: BaseFragment<*, *>) {
        childFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(viewId, baseFragment, baseFragment.javaClass.name)
                .commit()

        currentChildFragment = baseFragment
    }

    companion object {
        const val INVALID_ID = -1
    }
}