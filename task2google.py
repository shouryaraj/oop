# Google Task 2

def maze_sort(n, string):
    moves = n**2 -2
    string= string
    value = ""
    str = ["0"]*len(string)

    for i in range(len(string)):
        if string[i] == "E":
           str[i] = "S"
        else:
            str[i] = "E"


        print(str)
    value = ''.join(str)
    return value



input_T = int(input())

for j in range(input_T):


    input_N = int(input())
    input_string = input()
    result = maze_sort(input_N,input_string)

    print("Case #"+ str(j+1) +": " + result)