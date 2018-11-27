# Funcation Set Koan

This Koan ask you to implement a specail kind of set (_fun-set_) and some base
functions for set manipulation. 

A fun-set is a function that takes a non nil input elelment and
returns that input element if and only if the fun-set contains an
element equal to that element else the fun-set returns nil


## Provided Base Functions

There are two base functions provide for you to start with

* empty-set - is a fun-set that takes any input element and returns
  nil
* singleton-set - if a function that takes and element and returns a
  fun-set containing that element

## Functions You Must Implement

* __f-contains?__ - takes an fun set and el and returns true only if that
  elements exists in the fun set else false
* union - takes two fun-sets and returns a set that is the superset
  of all elements in either set1 or set2
* union-all - takes a list of fun sets and returns a fun set that is the
  superset of all elements containes in any of sets provided
* intersection - takes two fun sets and returns a set that contains only
  elements present in each of the two sets
* intersection-all - takes a list of fun sets and returns a set that contains
  only elements present in all of the sets provided
* f-conj - takes a fun set and an element and returns a fun set
  that contains all elements in the input set plus the
  element provided
* f-disj - takes a fun set and an element and returns a fun set1
  that contains all elements in the inputs set minus the
  element provided
* f-set - takes a vaiable number of  elements and creates a fun set
  that contains all the elements provided

## Testing

There are a set of unit tests that can be run to provide feedback your
implementations

```
$> lein test
```
