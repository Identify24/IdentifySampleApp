package com.identify.identifysampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.identify.sdk.IdentifyErrorListener
import com.identify.sdk.IdentifySdk
import com.identify.sdk.IdentityOptions
import com.identify.sdk.repository.model.enums.IdentifyModuleTypes
import com.identify.sdk.repository.model.enums.ModuleCacheType
import com.identify.sdk.repository.model.mrz.DocType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val identityOptions = IdentityOptions.Builder()
            .setIdentityType(
                listOf(
                    IdentifyModuleTypes.PREPARE,
                    IdentifyModuleTypes.SPEECH_TEST,
                    IdentifyModuleTypes.IDENTIFICATION_INFORMATION_WITH_CARD_PHOTO,
                    IdentifyModuleTypes.IDENTIFICATION_INFORMATION_WITH_NFC,
                    IdentifyModuleTypes.TAKE_SELFIE,
                    IdentifyModuleTypes.VALIDATE_ADDRESS,
                    IdentifyModuleTypes.LIVENESS_TEST,
                    IdentifyModuleTypes.VIDEO_RECORD,
                    IdentifyModuleTypes.SIGNATURE,
                    IdentifyModuleTypes.AGENT_CALL
                )
            )
            .setNfcExceptionCount(3)
            .setCallConnectionTimeOut(20000)
            .setOpenIntroPage(false)
            .setDocumentType(DocType.ID_CARD)
            .setOpenThankYouPage(false)
            .setVideoRecordTime(5000)
            .setCallConnectionTimeOut(5000)
            .setAutoSelfieWithLivenessDetection(false)
            .setEnableFaceControlInSelfie(true)
            .setEnableLightInformationInCall(true)
            .build()


        val identifyObject = IdentifySdk.Builder()
            .api("api url")
            .socket("socket url","socket port")
            .stun("stun url","stun port")
            .turn("turn url","turn port","turn username","turn password")
            .lifeCycle(this.lifecycle)
            .options(identityOptions)
            .build()

        identifyObject.startIdentification(this,"xxxx-xxxx-xxxx-xxxx-xxxxxxx","tr")
    }
}