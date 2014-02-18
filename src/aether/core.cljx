(ns aether.core)

(defn broken-identity-function
  "I don't do a whole lot."
  [x] x)


(def demo-form{:fields [{:name :h1 :type :heading :text "Section 1"}
                        {:name :full-name}
                        {:name "user[email]" :type :email}
                        {:name :spam :type :checkbox :label "Yes, please spam me."}]
               :validations [[:required [:full-name "user[email]"]]]
               :enctype "multipart/form-data"})
