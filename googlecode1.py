

#google Code

def cheque_generator(n):
   N = str(n)
   odd = False


   if (n % 2 == 0):
       A = n//2
       B = n//2
   else:
       A = n//2 + 1
       B = n//2 + 1
       odd = True
   C = str(A)
   D = str(B)
   k = len(C) - 1
   for j in range(0, len(C)):
       print ("jj")
       print(k)
       if (C[k] == "4"):
         print("hello")
         if k == (len(C) - 1):
             sub = 1
         else:
             sub = 10**j
         A-=sub
         B+=sub
         C = str(A)
         D = str(B)
         print(k)

       print(A,B)
       if (C.find("4") == -1 and D.find("4") == -1):
           if odd:
               A-=1
           return [str(A), str(B)]
       k = k - 1





input_T = int(input())

for j in range(input_T):


    input_N = int(input())
    result = cheque_generator(input_N)

    print("Case #"+ str(j+1) +": " + result[0] +" "+ result[1])

