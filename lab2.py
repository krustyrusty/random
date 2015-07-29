import time,datetime,os
import random

# number of processes
n=12

# number of interactive processes (80%)
interactiveCount=.8*n

# number of cpu bound processes (20%)
cpuBound = n - interactiveCount

class Processes():
    interactive = False
    ready = 0    #ready to use cpu
    active = 0   #actively using cpu
    blocked = 0  #blocked on I/O
    processID


    #if interactive, specify burst times by using random numbers between 20-200ms
    #if cpu bound, specify burst times by using random numbers between 200-3000ms
    def generateBurstTime(self):
        return burstTime = generateRandomNumber(.02, .200) if interactive=True else generateRandomNumber(.2, 3.0) #converted to seconds

    TODO: b=6 bursts
     #each cpu bound process will have b=6 bursts before terminating.
    #btwn bursts, each process is blocked on I/O for a random amount of time in the range 1000-4500ms.
    def cpuBoundBursts(self):
        blockTime = generateRandomNumber(1.0, 4.5)
        setState(0,0,1)
        time.sleep(blockTime)


    #when an interactive process completes its burst, the slow human user spends time responding.
    #after a random amount of time in range 1000-4500ms, the given process enters the ready queue again, ad infinitum
     def interactiveBurstComplete(self):
        waitTime = generateRandomNumber(1, 4.5) #converted to seconds
       setState(0,0,1)  #set state to block while waiting to re-enter ready queue
        time.sleep(waitTime)
        setState(1,0,0) #process enters the ready queue

    #pass in 0 or 1 to args to change the state of a process
    def setState(self, r, a, b):
        ready = r
        active = a
        blocked = b

   #each time a process enters the ready queue, it should be given a random amt of time for its current cpu

    def __init__(self,cnd):
        self.cnd = cnd
        self.id = raw_input('Enter Subject ID: ')
        self.age = raw_input('Enter Subject Age: ')
        self.gender = raw_input('Enter Subject Gender: ')

    def generateProcesses(self):



if __name__ == "__main__":
    S = Subject('A')
    L = Logger(['time','cnd', 'event', 'word','col','instr','reaction time', 'response', 'correct']) # header for stroop, col = color
    W = World()
    #pdb.set_trace()
    W.run()

    def generateRandomNumber(self, a, b):
        return random.randrange(a, b)
