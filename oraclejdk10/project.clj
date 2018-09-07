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
                                  [rewrite-clj/rewrite-clj "0.6.0"]
                                  [markdown-clj/markdown-clj "1.0.2"]
                                  [org.clojure/tools.analyzer.jvm "0.7.2"]
                                  [net.bytebuddy/byte-buddy "1.8.12"]

                                  [org.jogamp.gluegen/gluegen-rt "2.3.2"]
                                  [org.jogamp.gluegen/gluegen-rt-main "2.3.2"]
                                  [org.jogamp.jogl/jogl-all "2.3.2"]
                                  [org.jogamp.jogl/jogl-all-main "2.3.2"]
                                  [com.rabbitmq/amqp-client "5.2.0"]
                                  
                                  [com.sun.mail/javax.mail "1.6.1"]
                                  [javax.mail/javax.mail-api "1.6.1"]]}}
  :repl-options {:host "0.0.0.0"}
  :jvm-opts []
  :java-source-paths ["java"])
