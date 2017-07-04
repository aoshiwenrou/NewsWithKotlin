package com.jcking.newswithkotlin

import android.app.Application
import com.jcking.jhttp.HttpSettings
import com.jcking.newswithkotlin.http.HttpConstants
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.CertificateFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManagerFactory


/**
 *
 * @author Jcking
 * @time 2017/7/4 16:41
 */
class App: Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
        initHttp()
    }

    private fun initHttp() {
        HttpSettings.rootUrl = HttpConstants.UW_BASE_URL
        HttpSettings.showLog = BuildConfig.DEBUG
        HttpSettings.sslSocketFactory = getSSLSocketFactory(arrayOf(R.raw.certificate_name ,R.raw.certificate_20170525))
    }

    private fun getSSLSocketFactory(certificates: Array<Int>): SSLSocketFactory {
        val certificateFactory = CertificateFactory.getInstance("X.509")
        val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
        keyStore.load(null, null)
        for(i in certificates.indices){
            val certificate = getResources().openRawResource(certificates[i])
            keyStore.setCertificateEntry(i.toString(), certificateFactory.generateCertificate(certificate))
            certificate.close()
        }
        val sslContext = SSLContext.getInstance("TLS")
        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(keyStore)
        sslContext.init(null, trustManagerFactory.getTrustManagers(), SecureRandom())
        return sslContext.getSocketFactory()
    }

    companion object{
        private var instance: App? = null
        fun get(): App = instance!!
    }
}