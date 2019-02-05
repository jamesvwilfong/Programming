# CS2021 Homework 1
def egyptianMath(p,q):
    """reads two integers p and q from a user
    and uses the greedy approach to output a
    listing representing a sum of unit fractions,
    with sum equal to p/q
    >>> egyptianMath(7,10)
    1/5 + 1/2 = 7/10
    >>> egyptianMath(0,5)
    The fraction is equal to 0
    >>> egyptianMath(5,0)
    Error: q can not equal 0
    >>> egyptianMath(11,12)
    1/12 + 1/3 + 1/2 = 11/12
    >>> egyptianMath(5,5)
    1/1 + 1/1 + 1/1 + 1/1 + 1/1 = 5/5
    >>> egyptianMath(1,6)
    1/6 = 1/6
    """
    vals = []
    if(p == 0):
        print('The fraction is equal to 0')
    elif(q == 0):
        print('Error: q can not equal 0')
    elif(p == 1):
        print('1/',q,' = 1/',q,sep='')
    elif(p/q == 1):
        for ctr in range(p-1):
            print('1/1 + ',end='')
        print('1/1 = ',p,'/',q,sep='')
    else:
        a = p / q
        ctr = 1
        while(a > 0):
            a = a - 1/ctr
            if(a < -.0001):
                a = a + 1/ctr
                ctr+=1
            else:
                vals.append(ctr)
        while(len(vals) != 1):
            print('1/',vals.pop(),' + ',sep='',end='')
        print('1/',vals.pop(),' = ',p,'/',q,sep='')

def _test():

    import doctest
    doctest.testmod(verbose=True)

if __name__ == "__main__":
    _test()
