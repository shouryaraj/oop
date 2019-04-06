

#google Code

def cheque_generator(n):
   N = str(n)
   C = "4"
   D= "4"
   k = len(N) - 1
   b = 0
   A = n
   B = 0
   if(N.find("4") == -1):
       if(N[len(N)-1] == "5"):
           A = n - 2
           B = 2
           return [str(A), str(B)]
       else:
           A = n-1
           B = 1
           return [str(A), str(B)]
   for j in range(0, len(N)):


       if (str(A)[k] == "4"):

           if k == (len(N) - 1):
               sub = 1
           else:
               sub = 10 ** j
           A -= sub
           B += sub
           C = str(A)
           D = str(B)


       k = k - 1

       if (C.find("4") == -1 and D.find("4") == -1):
           return [str(A), str(B)]








input_T = int(input())

for j in range(input_T):


    input_N = int(input())
    result = cheque_generator(input_N)

    print("Case #"+ str(j+1) +": " + result[0] +" "+ result[1])


