(ns fun-set.core)

;; A fun-set is a function that takes a non nil input element
;; and returns that input element if and only if the fun-set
;; contains an element equal to that element else returns nil

(defn empty-set
  "takes any input element and returns nil"
  [_] nil)

(defn singleton-set
  "takes an element and returns a fun-set containing
   just that element"
  [el1]
  (fn [el2]
    (when (= el2 el1) el2)))

(defn f-contains?
  "takes an fun set and el and returns true only if that
   elements exists in the fun set else false"
  [f-set el]
  ;;TODO
  )


(defn union
  "takes two fun-sets and returns a set that is the superset
   of all elements in either set1 or set2"
  [f-set1 f-set2]
  ;;TODO
  )

(defn union-all
  "takes a list of fun sets and returns a fun set that is the
   superset of all elements containes in any of sets provided"
  [& f-sets]
  ;; TODO
  )


(defn intersection
  "takes two fun sets and returns a set that contains only
   elements present in each of the two sets"
  [f-set1 f-set2]
  ;; TODO
  )

(defn intersection-all
  "takes a list of fun sets and returns a set that contains
   only elements present in all of the sets provided"
  [& f-sets]
  ;;TODO
  )


(defn f-conj
  "takes a fun set and an element and returns a fun set
   that contains all elements in the input set plus the
   element provided"
  [f-set el]
  ;; TODO
  )

(defn f-disj
  "takes a fun set and an element and returns a fun set1
   that contains all elements in the inputs set minus the
   element provided"
  [f-set el1]
  ;; TODO
  )

(defn f-set
  "takes a vaiable number of  elements and creates a fun set
   that contains all the elements provided"
  [& els]
  ;; TODO
  )
