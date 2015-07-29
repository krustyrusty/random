:-[read_line].
  :-dynamic sentence/2.

  getPredicate(sentence(N V))  -->  the, noun(N), jane, verb(V), end.
  /* getPredicate(neg_sentence(N PV))  -->  the, noun(N),_, did_not, pres_verb(PV), end.*/
jane --> ['jane'].
  the --> ['the'].
    did_not -->['did not'].
  end --> ['.'].
  
   noun(train)  -->  ['train']. 
   noun(bike)      -->  ['bike']. 
   noun(person)      -->  ['person']. 
    
  verb(flew)  -->  ['flew'].
  verb(left)  -->  ['left'].
  verb(arrived)  -->  ['arrived'].
  verb(stayed)  -->  ['stayed'].

  pres_verb(leave) --> ['leave'].
  pres_verb(fly) --> ['fly'].
  pres_verb(arrive) --> ['arrive'].
  pres_verb(stay) --> ['stay'].

  

 loop:- read_line(X), getPredicate(Y, X, []), assert(Y), loop.
