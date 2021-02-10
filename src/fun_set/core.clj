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
  (not (nil? (f-set el)))
  )

(defn union
  "takes two fun-sets and returns a set that is the set
   of all elements in either set1 or set2."
  [f-set1 f-set2]
  (fn [el] ;;<- returning new fun-set composed of f-set1 and f-set2
    (when (or (f-contains? f-set1 el)
              (f-contains? f-set2 el))
      el))
  )

(defn union-all
  "takes a list of fun sets and returns a fun set that is the
   set of all elements in any of sets provided."
  [& f-sets]
  (fn [el]
    (when (some #(f-contains? % el) f-sets)
      el))
  )

(defn intersection
  "takes two fun sets and returns a set that contains only
   elements present in each of the two sets"
  [f-set1 f-set2]
  (fn [el] ;;<- returning new fun-set composed of f-set1 and f-set2
    (when (and (f-contains? f-set1 el)
              (f-contains? f-set2 el))
      el))
  )

(defn intersection-all
  "takes a list of fun sets and returns a set that contains
   only elements present in all of the sets provided"
  ([] empty-set)
  ([& f-sets]
  (fn [el]
    (when (every? #(f-contains? % el) f-sets)
      el))
  ))

; Tests fail for these last 3 functions. I ran out of time and was
; unable to get f-conj to pass test.
(defn f-conj
  "takes a fun set and an element and returns a fun set
   that contains all elements in the input set plus the
   element provided"
  [f-set el]
  (fn [el2]
    ; "input set plus element provided" means:
    ; f-set fun-set contains the el2 number
    ; OR el number "contains" the el2 number, which is just an equality check
    ; In either case, return the el2 input
    (when (or (f-contains? f-set el2)
              (= el el2))
      el2)
    )
  )

(defn f-disj
  "takes a fun set and an element and returns a fun set1
   that contains all elements in the inputs set minus the
   element provided"
  [f-set el1]
  (fn [el2]
    ; similar to f-conj except that we want the intersection of A and not B
    (when (and (f-contains? f-set el2)                      ; A
              (not= el1 el2))                               ; B
      el2)
    )
  )

(defn f-set
  "takes a vaiable number of  elements and creates a fun set
   that contains all the elements provided"
  [& els]
  (fn [el]
    ; similar to union-all except that we do a simple equality check on numbers (like in f-conj) instead of f-contains?
    (when (some #(= % el) els)
      el))
  )
