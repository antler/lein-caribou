(ns leiningen.caribou
  (:use [leiningen.help :only (help-for subtask-help-for)]
        [leiningen.caribou.catapult :only (catapult)]
        leiningen.caribou.create
        leiningen.caribou.migrate
        leiningen.caribou.server
        leiningen.caribou.war
        leiningen.caribou.uberwar
        leiningen.caribou.versions))
      
(defn caribou
  "Creates new caribou projects"
  {:help-arglists '([catapult create migrate rollback start stop uberwar uberwar-all])
   :subtasks [#'catapult #'create #'migrate #'rollback #'start #'stop #'uberwar #'uberwar-all]
   :no-project-needed true}
  ([project]
     (println (help-for "caribou")))
  ([project subtask & args]
     (let [subtask-args (cons project args)]
       (condp = subtask
         "catapult" (apply catapult subtask-args)
         "create" (apply create subtask-args)
         "migrate" (apply migrate subtask-args)
         "rollback" (apply rollback subtask-args)
         "start" (apply start subtask-args)
         "stop" (apply stop subtask-args)
         "uberwar" (apply uberwar subtask-args)
         "uberwar-all" (apply uberwar-all subtask-args)
         "versions" (apply versions subtask-args)
         (println "No command by that name")))))
