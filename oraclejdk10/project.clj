(require 'cemerick.pomegranate.aether)
(cemerick.pomegranate.aether/register-wagon-factory!
 "http"
 #(proxy [org.apache.maven.wagon.providers.http.HttpWagon] []
    (get [^String res ^java.io.File f]
      (println "HTTP Wagon get:" res "from" f)
      (proxy-super get res f))))

(defproject hara "3.0.1"
  :description "all base libraries for caudata"
  :url "https://gitlab.com/caudata/base" 
  :aliases {"test"    ["run" "-m" "hara.test" "exit"]
            "publish" ["exec" "-ep" "(use 'hara.publish) (deploy-template :all) (publish :all)"]}
  :repositories {"osgeo" "https://download.osgeo.org/webdav/geotools/"}
  :dependencies 
  [;; dev
   [org.clojure/clojure "1.9.0"]
 
   ;; hara.string.diff
   [com.googlecode.java-diff-utils/diffutils "1.3.0"]
   
   ;; hara.core.config
   [org.yaml/snakeyaml "1.23"]
   
   ;; hara.lib.jsoup
   [org.jsoup/jsoup "1.11.3"]

   ;; hara.io.json
   [com.fasterxml.jackson.core/jackson-databind "2.9.7"]
   [com.fasterxml.jackson.datatype/jackson-datatype-jsr310 "2.9.7"]
 
   ;; hara.jvm
   [org.ow2.asm/asm "6.2.1"]

   ;; hara.lib.osgi
   [org.apache.felix/org.apache.felix.framework "6.0.1"]
   [org.apache.felix/org.apache.felix.gogo.runtime "1.1.0"]
   [org.apache.felix/org.apache.felix.gogo.jline "1.1.0"]
   [org.apache.felix/org.apache.felix.gogo.command "1.0.2"]

   ;; hara.code
   [org.clojure/tools.reader "1.3.0"]
  
   ;; hara.publish
   [markdown-clj/markdown-clj "1.0.4"]

   ;; hara.security.openpgp
   [org.bouncycastle/bcprov-jdk15on "1.60"]
   [org.bouncycastle/bcpg-jdk15on "1.60"]
 
   ;; hara.pretty
   [org.clojure/core.rrb-vector "0.0.13"]
 
   ;; hara.lib.aether
   [org.eclipse.aether/aether-api "1.1.0"]
   [org.eclipse.aether/aether-spi "1.1.0"]
   [org.eclipse.aether/aether-util "1.1.0"]
   [org.eclipse.aether/aether-impl "1.1.0"]
   [org.eclipse.aether/aether-connector-basic "1.1.0"]
   [org.eclipse.aether/aether-transport-wagon "1.1.0"]
   [org.eclipse.aether/aether-transport-http "1.1.0"]
   [org.eclipse.aether/aether-transport-file "1.1.0"]
   [org.eclipse.aether/aether-transport-classpath "1.1.0"]
   [org.apache.maven/maven-aether-provider "3.3.9"]
   [org.apache.maven.wagon/wagon-webdav-jackrabbit "3.2.0"]

   ;; hara.extern
   [com.github.jnr/jnr-ffi "2.1.9" :exclusions [org.ow2.asm/asm]]
   [com.github.jnr/jnr-unixsocket "0.20"]
   [com.github.jnr/jnr-posix "3.0.46"]


   ;; hara.lib.jgit
   [org.eclipse.jgit/org.eclipse.jgit "5.1.1.201809181055-r"]

   ;; hara.lib.oshi
   [com.github.oshi/oshi-core "3.9.1"]  
 
   ;; hara.math
   [net.sourceforge.jdistlib/jdistlib "0.4.5"]

   ;; hara.lib.zxing
   [com.google.zxing/core "3.3.3"]
   [com.google.zxing/javase "3.3.3"
    :exclusions [com.beust/jcommander
                 com.github.jai-imageio/jai-imageio-core]]
 
   ;; hara.lang.scala
   [org.scala-lang/scala-library "2.12.7"]
   [org.scala-lang/scala-compiler "2.12.7"]

   ;; hara.lib.datomic
   [com.datomic/datomic-free "0.9.5697" :exclusions [com.google.guava/guava]]
 
   ;; hara.lib.rabbitmq
   [http-kit "2.3.0"]
   [com.rabbitmq/amqp-client "5.4.3"]
 
   ;; hara.lib.gdal
   [org.gdal/gdal "2.3.2"]
 
   ;; hara.time
   [joda-time/joda-time "2.10"]
 
   ;; hara.lib.worldwind
   [com.github.pcmehlitz/worldwind-pcm "2.1.0.187" :exclusions [org.gdal/gdal]]
   [org.jogamp.gluegen/gluegen-rt "2.3.2"]
   [org.jogamp.gluegen/gluegen-rt-main "2.3.2"]
   [org.jogamp.jogl/jogl-all "2.3.2"]
   [org.jogamp.jogl/jogl-all-main "2.3.2"]

   ;; hara.lib.opencl
   [uncomplicate/clojurecl "0.10.3"]

   ;; hara.lib.blast
   [uncomplicate/neanderthal "0.20.4"
     :exclusions
     [org.jcuda/jcuda-natives 
      org.jcuda/jcublas-natives]]
 
   ;; server
   ;;[org.immutant/web "2.1.10"]

   ;; hara.fx
   [org.openjfx/javafx-controls "11"]
   [org.openjfx/javafx-swing "11"]
   [org.openjfx/javafx-base "11"]
   [org.openjfx/javafx-graphics "11"]
 
   ;; hara.lib.opencv
   [org.openpnp/opencv "3.4.2-0"]
 
   ;; hara.lib.geotools
   [org.geotools/gt-api "20.0"]
   [org.geotools/gt-epsg-hsql "20.0"]
   [org.geotools/gt-geotiff "20.0"]
   [org.geotools/gt-main "20.0"]
   [org.geotools/gt-opengis "20.0"]
   [org.geotools/gt-referencing "20.0"]
   [org.geotools/gt-sample-data "20.0"]
   [org.geotools/gt-shapefile "20.0"]

   ;; hara.lib.antlr
   [org.antlr/antlr4-runtime "4.7.1"]
   [org.antlr/antlr4 "4.7.1"]

   ;; hara.net.oauth
   [com.github.scribejava/scribejava-apis "6.0.0"]
 
   ;; hara.platform
   [com.sun.mail/javax.mail "1.6.2"]
   [javax.mail/javax.mail-api "1.6.2"]]
  
  :injections  [(require 'hara.tool)]

  :profiles {:dev {:plugins [[lein-ancient "0.6.15"]
                             [lein-exec "0.3.7"]
                             [cider/cider-nrepl "0.18.0"]]}}
  
  :package [[:file "config/package.edn"]]
  
  :deploy  {:all     [[:file "config/deploy.all.edn"]]
            :dev     [[:file "config/deploy.dev.edn"]]
            :public  [[:file "config/deploy.public.edn"]]
            :native  [[:file "config/native.edn"]]}
                      
  :publish {:all     [[:file "config/publish.all.edn"]]
            :dev     [[:file "config/publish.dev.edn"]]
            :public  [[:file "config/publish.public.edn"]]}
  
  :java-source-paths ["code/java"]
  :java-output-path  "target/classes"
  :repl-options {:host "0.0.0.0"}
  :jvm-opts 
  ["-Xmx1g"
   "-Djdk.attach.allowAttachSelf=true"
   "--add-opens" "javafx.graphics/com.sun.javafx.util=ALL-UNNAMED"
   "--add-opens" "java.base/java.lang=ALL-UNNAMED"
   "--illegal-access=permit"])
