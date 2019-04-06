# task3Google
import math
def prime_number(num):
    sqrt_num = num//2
    end = sqrt_num
    store = []
    i = sqrt_num
    count = num//2
    while count > 0:
        if i > 1:
          if(num % i == 0):
            store.append(i)
        elif(num % end == 0):
            store.append(end)
        i-=1
        end+=1
        if(len(store) >= 2):
            break
        count-=1
    return sorted(store)

def crytography(range, ciper, list):
    prime_array = []
    sorted_array = []

    alphabet_array = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                      'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                      'U', 'V', 'W', 'X', 'Y', 'Z']
    i= 0

    while i < (len(list)):
        if i == 0:
          values = prime_number(list[i])
          prime_array.append(values[0])
          prime_array.append(values[1])
          print(prime_array)
        else:
            value = list[i]/prime_array[i]
            prime_array.append((value))
        i+=1

    sorted_array = sorted(prime_array)
    j = 0
    index = 0
    code = ['**']*len(sorted_array)
    while j < len(sorted_array):
        k = 0
        if (j >= 1 and sorted_array[j] != sorted_array[j - 1]):

            index += 1
        while k < len(prime_array):
           if(sorted_array[j] == prime_array[k]):
                code[k]= alphabet_array[index]

           k+=1


        j+= 1
    value = ''.join(code)
    return value

print(prime_number(1891))
#list = [217, 1891, 4819, 2291, 2987, 3811, 1739, 2491, 4717, 445, 65, 1079, 8383, 5353, 901, 187,649, 1003, 697, 3239, 7663, 291, 123, 779, 1007, 3551, 1943, 2117, 1679, 989, 3053]

list = [3292937,175597,18779,50429,375469,1651121,2102,3722,2376497,611683,489059,2328901,3150061
    ,829981,421301,76409,38477,291931,730241,959821,1664197,3057407,4267589,4729181,5335543]

print(crytography(10000000, 25, list))



