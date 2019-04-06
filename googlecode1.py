

#google Code

def cheque_generator(n):
   N = str(n)
   okay = True

   if (n % 2 == 0):
       A = n//2
       B = n//2
   else:
       A = n//2 + 1
       B = n// 2
   C = str(A)
   D = str(B)
   if (C.find("4") == -1 and D.find("4") == -1):
       return [str(A), str(B)]

   k = len(C) - 1
   for j in range(0,len(C)):

       if (C[k] == "4"):
         sub = 10**j
         A-=sub
         B+=sub
         E = str(A)
         F = str(B)
         if (E.find("4") == -1 and F.find("4") == -1):
            return [str(A), str(B)]
       k = k -1





input_T = int(input())

for j in range(input_T):


    input_N = int(input())
    result = cheque_generator(input_N)

    print("Case #"+ str(j+1) +": " + result[0] +" "+ result[1])

