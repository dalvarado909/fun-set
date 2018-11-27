# Funcation Set Koan

This Koan ask you to implement a specail kind of set (_fun-set_) and some base
functions for set manipulation. 

A fun-set is a function that takes a non nil input elelment and
returns that input element if and only if the fun-set contains an
element equal to that element else the fun-set returns nil


## Provided Base Functions

There are two base functions provide for you to start with

* __empty-set__ - is a fun-set that takes any input element and returns
  nil
* __singleton-set__ - if a function that takes and element and returns a
  fun-set containing that element

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

## Testing

There are a set of unit tests that can be run to provide feedback your
implementations

```
$> lein test
```

## Submitting a Solutions

Please create a branch with the following format
solution.first_name.last-name and push your code to it.  This is the
honor system so don't look at other branches until you finish your solution.

