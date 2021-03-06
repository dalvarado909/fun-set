# Function Set Koan

This Koan ask you to implement a special kind of set (_fun-set_) and some base
functions for set manipulation. 

A fun-set is a function that takes a non nil input elelment and
returns that input element if and only if the fun-set contains an
element equal to that element else the fun-set returns nil


## Provided Base Functions

There are two base functions provide for you to start with

* __empty-set__ - is a __fun-set__ that takes any input element and returns
  nil
* __singleton-set__ - if a __function__ that takes and element and returns a
  __fun-set__ containing that element

## Functions You Must Implement

* __f-contains?__ - takes an fun set and el and returns true only if that
  elements exists in the fun set else false
* __union__ - takes two fun-sets and returns a set that is the superset
  of all elements in either set1 or set2
* __union-all__ - takes a list of fun sets and returns a fun set that is the
  superset of all elements containes in any of sets provided
* __intersection__ - takes two fun sets and returns a set that contains only
  elements present in each of the two sets
* __intersection-all__ - takes a list of fun sets and returns a set that contains
  only elements present in all of the sets provided
* __f-conj__ - takes a fun set and an element and returns a fun set
  that contains all elements in the input set plus the
  element provided
* __f-disj__ - takes a fun set and an element and returns a fun set1
  that contains all elements in the inputs set minus the
  element provided
* __f-set__ - takes a vaiable number of  elements and creates a fun set
  that contains all the elements provided
  
## Where do I start?

It is important to understand that fun-set is not like any set you have seend before.  Instead of a data structure you can inspect a fun-set is just a function that closes over some state.  When called the function looks at it's internal state and if that matches the provided element that provided element is returned else nil is returned.  

Building a singleton-set illustrates this:

```clj
(defn singleton-set
  "takes an element and returns a fun-set containing
   just that element"
  [el1]
  (fn [el2]
    (when (= el2 el1) el2)))
```

_important_: Notice how the function `single-set` is __not__ a fun set but a __builder__ for fun sets.  It returns a `fun-set`. 

#### Let's look at `f-contains?` and `union`

__f-contains?__ - We need to implement a function that takes fun-set and an element and return true or false depending if that element is in the fun-set.  Since the fun-set is a function I can call it with the element and it will return the element if it exist or `nil` if not.  So if something other than `nil` is returned by calling the fun-set I should return true and if nil is returned I should return false.

```clj
(defn f-contains?
  "takes an fun set and el and returns true only if that
   elements exists in the fun set else false"
  [f-set el]
  (not (nil? (f-set el)))
```

_important_: there are other implemenation that work just as well but this gives you an idea.

__union__ - In this case we need to implement a function that takes two fun-sets and return a new fun-set the element if and only if element exists in either of the sub fun-sets and nil otherwise.  It is very important to realize that all operations like `union`, `union-all`, `intersection` and `intersection-all` build new fun-sets.  To do this we can use the `f-contains?` and call it for each sub `fun-set` and return the element if both return true for that element.

```clj
(defn union
  "takes two fun-sets and returns a fun-set that is the superset
   of all elements in either set1 or set2"
  [f-set1 f-set2]
  (fn [el] ;;<- returning new fun-set composed of f-set1 and f-set2
    (when (or (f-contains? f-set1 el) 
              (f-contains? f-set2 el))
      el)))

```
_important_: this exercise builds small operations up to be used in building future operations.  So like our use to `f-contains?` here in union you will use `union` in building other functions.

## Testing

There are a set of unit tests that can be run to provide feedback your
implementations

```
$> lein test
```

Running a single test:
```
    lein test :only fun-set.core-test/test-name
```

Replace `test-name` with the name of particular test, for example,
`empty-set-test`.

## Submitting a Solutions

Please create a branch with the following format
solution.first_name.last-name and push your code to it.  This is the
honor system so don't look at other branches until you finish your solution.

