;;Based off implementation from the noir framework
;;http://webnoir.org/

(ns leiningen.caribou
  (:use [leiningen.help :only (help-for subtask-help-for)]
        leiningen.caribou.create
        leiningen.caribou.bootstrap
        leiningen.caribou.server
        leiningen.caribou.war
        leiningen.caribou.uberwar))
      

;; ^{:no-project-needed true} 
(defn caribou
  "Creates new caribou projects"
  {:help-arglists '([create bootstrap start stop uberwar uberwar-all])
   :subtasks [#'create #'bootstrap #'start #'stop #'uberwar #'uberwar-all]
   :no-project-needed true}
  ([project]
     (println (help-for "caribou")))
  ([project subtask & args]
     (let [subtask-args (cons project args)]
       (condp = subtask
         "create" (apply create subtask-args)
         "bootstrap" (apply bootstrap subtask-args)
         "start" (apply start subtask-args)
         "stop" (apply stop subtask-args)
         "uberwar" (apply uberwar subtask-args)
         "uberwar-all" (apply uberwar-all subtask-args)
         (println "No command by that name")))))
