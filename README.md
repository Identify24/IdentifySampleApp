# IdentifySampleApp

MainActivity içerisinden Api Url, socket url/port, stun url/port, turn url/port/username/password ve ident id bilgilerini doldurmalısınız.
<pre>
          val identifyObject = IdentifySdk.Builder()
            .api("api url")
            .socket("socket url","socket port")
            .stun("stun url","stun port")
            .turn("turn url","turn port","turn username","turn password")
            .lifeCycle(this.lifecycle)
            .options(identityOptions)
            .build()

        identifyObject.startIdentification(this,"xxxx-xxxx-xxxx-xxxx-xxxxxxx","tr")
</pre>


settings.gradle içerisinden SDK’e erişiminiz için credentials bölümündeki value değeri doldurulmalıdır. Bu veri elinizde yoksa bizimle iletişime geçin.


 <pre>allprojects {
repositories {
...
   maven {
            url 'https://gitlab.com/api/v4/projects/26590072/packages/maven'
            name "GitLab"
            credentials(HttpHeaderCredentials) {
                name = 'Private-Token'
                value = 'xxxxxxxxxxxxxxx'
            }
            authentication {
                header(HttpHeaderAuthentication)
            }
        }
}
}</pre>
