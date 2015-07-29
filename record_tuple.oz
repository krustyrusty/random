 %display a list consisting of two elements one is a record, and the other is tuple having the same label and fields:

declare T I Y LT RT W in 
T = tree(key:I value:Y left:LT right:RT) %record; args are Feature:Field
I = seif
Y = 43
LT = nil
RT = nil
W = tree(I Y LT RT) %tuple; omits record Features
{Browse [T W]}

% To select a field of a record component, we use the infix dot operator:
% Record.Feature

% Selecting a Component
{Browse T.key}
{Browse W.1}

% will show seif twice in the browser
%seif
%seif

%The arity of a record is a list of the features of the record sorted lexicographically. To display the arity of a record we use the procedure Arity. The procedure application {Arity R X} will execute once R is bound to a record, and will bind X to the arity of the record. Executing the following statements

% Getting the Arity of a Record
local X in {Arity T X} {Browse X} end 
local X in {Arity W X} {Browse X} end