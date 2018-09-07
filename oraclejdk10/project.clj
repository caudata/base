(defproject caudata/base "3.0.1"
  :description "all base libraries for caudata"
  :url "https://gitlab.com/caudata/base"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/tools.reader "1.3.0"]
                 [org.jsoup/jsoup "1.11.3"]
                 [com.github.oshi/oshi-core "3.6.0"]
                 [com.googlecode.java-diff-utils/diffutils "1.3.0"]]
  :aliases {"test" ["run" "-m" "hara.test" "exit"]
            "publish" ["exec" "-ep" "(use 'hara.tool.publish) (deploy-template :all) (publish :all)"]
            "deploy"  ["exec" "-ep" "(use 'hara.tool.deploy) (deploy 'hara.core {:repository *caudata-repo*}) (deploy :all {:repository *caudata-repo*})"]}
  :injections  [(require  '[hara.module.inject :as inject])
                (inject/in [hara.io.project project]
                           [hara.module.namespace reset]
                           [hara.tool.aether pull push]

                           clojure.core
                           [hara.reflect .& .> .? .* .% .%> .>var .>ns])]
  :profiles {:dev {:dependencies [[org.eclipse.jgit "5.0.1.201806211838-r"]
                                  [joda-time "2.10"]
                                  [org.clojure/core.async "0.4.474"
                                   :exclusions [org.clojure/tools.reader]]

                                  [binaryage/devtools "0.9.7"]
                                  [cider/cider-nrepl "0.18.0" :exclude [nrepl/nrepl]]
                                  
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

                                  [com.fasterxml.jackson.core/jackson-databind "2.9.6"
                                   :exclusions [com.fasterxml.jackson.core/jackson-annotations]]
                                  [com.fasterxml.jackson.core/jackson-annotations "2.9.6"]
                                  [com.fasterxml.jackson.datatype/jackson-datatype-jsr310 "2.9.6"]

                                  [org.ow2.asm/asm "6.2"]
                                  [org.bouncycastle/bcprov-jdk15on "1.59"]
                                  [org.bouncycastle/bcpg-jdk15on "1.59"]
                                  [net.bytebuddy/byte-buddy "1.8.12"]

                                  [org.scala-lang/scala-library "2.12.6"]
                                  [org.scala-lang/scala-compiler "2.12.6"]

                                  [org.gdal/gdal "2.3.0"]
                                  [com.github.pcmehlitz/worldwind-pcm "2.1.0.187" :exclusions [org.gdal/gdal]]
                                  [org.jogamp.gluegen/gluegen-rt "2.3.2"]
                                  [org.jogamp.gluegen/gluegen-rt-main "2.3.2"]
                                  [org.jogamp.jogl/jogl-all "2.3.2"]
                                  [org.jogamp.jogl/jogl-all-main "2.3.2"]
  
                                  [org.geotools/gt-api "19.2"]
                                  [org.geotools/gt-epsg-hsql "19.2"]
                                  [org.geotools/gt-geotiff "19.2"]
                                  [org.geotools/gt-main "19.2"]
                                  [org.geotools/gt-opengis "19.2"]
                                  [org.geotools/gt-referencing "19.2"]
                                  [org.geotools/gt-sample-data "19.2"]
                                  [org.geotools/gt-shapefile "19.2"]
                                  
                                  [com.rabbitmq/amqp-client "5.2.0"]
                                  
                                  [com.sun.mail/javax.mail "1.6.1"]
                                  [javax.mail/javax.mail-api "1.6.1"]]}}
  :repl-options {:host "0.0.0.0"}
  :jvm-opts []
  :java-source-paths ["java"])
