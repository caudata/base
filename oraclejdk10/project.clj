(require 'cemerick.pomegranate.aether)
(cemerick.pomegranate.aether/register-wagon-factory!
 "http"
 #(proxy [org.apache.maven.wagon.providers.http.HttpWagon] []
    (get [^String res ^java.io.File f]
      (println "HTTP Wagon get:" res "from" f)
      (proxy-super get res f))))

(defproject caudata/base "3.0.1"
  :description "all base libraries for caudata"
  :url "https://gitlab.com/caudata/base"
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :repositories {"osgeo" "https://download.osgeo.org/webdav/geotools/"}
  :profiles {:dev {:dependencies [;; dev
  [expound "0.7.1"]
  [binaryage/devtools "0.9.10"]
  [cider/cider-nrepl "0.18.0" :exclude [nrepl/nrepl]]
  [virgil "0.1.8" :exclusions [org.ow2.asm/asm
                               org.clojure/tools.namespace]] ;; GET WORKING
  
  ;; hara.string.diff
  [com.googlecode.java-diff-utils/diffutils "1.3.0"]

  ;; hara.io.html
  [org.jsoup/jsoup "1.11.3"]

  ;; hara.io.json
  [com.fasterxml.jackson.core/jackson-databind "2.9.6"]
  [com.fasterxml.jackson.datatype/jackson-datatype-jsr310 "2.9.6"]
  
  ;; hara.tool.java
  [org.ow2.asm/asm "6.2.1"]
  [net.bytebuddy/byte-buddy "1.8.22"]
    
  ;; hara.code.block
  [org.clojure/tools.reader "1.3.0"]

  ;; hara.code.deploy
  [org.bouncycastle/bcprov-jdk15on "1.60"]
  [org.bouncycastle/bcpg-jdk15on "1.60"]

  ;; hara.code.publish
  [markdown-clj/markdown-clj "1.0.2"]
  
  ;; hara.pretty
  [org.clojure/core.rrb-vector "0.0.11"]
  
  ;; hara.time
  [joda-time "2.10"]
  
  ;; hara.tool.aether
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
  [org.apache.maven.wagon/wagon-webdav-jackrabbit "3.1.0"]

  ;; hara.tool.jna
  [net.java.dev.jna/jna "4.5.2"]

  ;; hara.tool.git
  [org.eclipse.jgit "5.0.3.201809091024-r"]

  ;; hara.jvm.system
  [com.github.oshi/oshi-core "3.8.2"]  

  ;; spirit.common.qrcode
  [com.google.zxing/core "3.3.3"]
  [com.google.zxing/javase "3.3.3"
   :exclusions [com.beust/jcommander
                com.github.jai-imageio/jai-imageio-core]]
  
  ;; hara.lib.scala
  [org.scala-lang/scala-library "2.12.6"]
  [org.scala-lang/scala-compiler "2.12.6"]
  
  ;; spirit.io.datomic
  [com.datomic/datomic-free "0.9.5697" :exclusions [com.google.guava/guava]]
  
  ;; spirit.io.rabbitmq
  [http-kit "2.3.0"]
  [com.rabbitmq/amqp-client "5.4.1"]
  
  ;; spirit.net.gdal
  [org.gdal/gdal "2.3.0"]
  [com.github.pcmehlitz/worldwind-pcm "2.1.0.187" :exclusions [org.gdal/gdal]]
  [org.jogamp.gluegen/gluegen-rt "2.3.2"]
  [org.jogamp.gluegen/gluegen-rt-main "2.3.2"]

  [org.jogamp.jocl/jocl-main "2.3.2"]
  [org.jogamp.jocl/jocl "2.3.2"]
  [org.jogamp.jogl/jogl-all "2.3.2"]
  [org.jogamp.jogl/jogl-all-main "2.3.2"]
  [org.openpnp/opencv "3.4.2-0"]
  
  [org.geotools/gt-api "19.2"]
  [org.geotools/gt-epsg-hsql "19.2"]
  [org.geotools/gt-geotiff "19.2"]
  [org.geotools/gt-main "19.2"]
  [org.geotools/gt-opengis "19.2"]
  [org.geotools/gt-referencing "19.2"]
  [org.geotools/gt-sample-data "19.2"]
  [org.geotools/gt-shapefile "19.2"]

  ;; parsing
  [org.antlr/antlr4-runtime "4.7.1"]
  [org.antlr/antlr4 "4.7.1"]
  
  ;; readline
  [com.bhauman/rebel-readline "0.1.4"]
  
  ;; spirit.net.oauth
  [com.github.scribejava/scribejava-apis "5.5.0"]
  
  ;; spirit.net.mail
  [com.sun.mail/javax.mail "1.6.2"]
  [javax.mail/javax.mail-api "1.6.2"]]}}
  :repl-options {:host "0.0.0.0"}
  :jvm-opts []
  :java-source-paths ["java"])