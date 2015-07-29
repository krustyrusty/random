
  sentence(sentence(NOM,VP))  -->  the, nom(NOM),_, vp(VP), end.
  sentence(sentence(NOM,PV))  -->  the, nom(NOM),_, 'did not', pv(PV), end.

  vp(vp(V))  -->  verb(V).
  nom(nom(N))  -->  noun(N).
  pv(pv(PV)) --> pres_verb(PV).
  end --> ['.'].
  
noun(noun(train))  -->  [train]. 
   noun(noun(bike))      -->  [bike]. 
   noun(noun(person))      -->  [person]. 
    
   verb(verb(flew))  -->  [flew].
   verb(verb(left))  -->  [left].
   verb(verb(arrived))  -->  [arrived].
   verb(verb(stayed))  -->  [stayed].

  pres_verb(pres_verb(leave)) --> [leave].
    pres_verb(pres_verb(fly)) --> [fly].
      pres_verb(pres_verb(arrive)) --> [arrive].
        pres_verb(pres_verb(stay)) --> [stay].
