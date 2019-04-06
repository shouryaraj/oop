

#google Code

def cheque_generator(n):
   N = str(n)
   obb = False


   if (n % 2 == 0):
       A = n//2
       B = n//2
   else:
       A = n//2 + 1
       B = n//2 + 1
       obb = True
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
       elif(D[k] == "4"):
          print("shit")
          if k == (len(C) - 1):
              sub = 1
          else:
              sub = 10 ** j
          A += sub
          B -= sub
          C = str(A)
          D = str(B)

       print(A,B)
       if (C.find("4") == -1 and D.find("4") == -1):
           if obb:
               A-=1
           return [str(A), str(B)]
       k = k - 1





for i in range (100000,100006):
    input_N = i


    result = cheque_generator(input_N)

    print("Case #"+ str(i) +": " + result[0] +" "+ result[1])

