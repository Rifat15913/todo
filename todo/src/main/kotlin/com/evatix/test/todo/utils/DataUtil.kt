package com.evatix.test.todo.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*
import javax.xml.bind.DatatypeConverter


class DataUtil {
    companion object {
        @Throws(NoSuchAlgorithmException::class)
        fun hashIntoSHA256(originalText: String): String {
            val md: MessageDigest = MessageDigest.getInstance("SHA-256")
            md.update(originalText.toByteArray())
            val digest: ByteArray = md.digest()
            return String(DatatypeConverter.printHexBinary(digest).toCharArray())
        }
    }
}