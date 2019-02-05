"""Required questions for lab 1"""

## Boolean Operators ##

# Q4
def both_positive(x, y):
    """Returns True if both x and y are positive.

    >>> both_positive(-1, 1)
    False
    >>> both_positive(1, 1)
    True
    """
    "*** YOUR CODE HERE ***"
    return x > 0 and y > 0


## while Loops ##

# Q9
def factors(n):
    """Prints out all of the numbers that divide `n` evenly.

    >>> factors(20)
    20
    10
    5
    4
    2
    1
    """
    "*** YOUR CODE HERE ***"
    ctr = 1
    while(ctr <= n):
        if(n%ctr == 0):
            print(int(n/ctr))
        ctr = ctr + 1


# Q10
def fib(n):
    """Returns the nth Fibonacci number.

    >>> fib(0)
    0
    >>> fib(1)
    1
    >>> fib(2)
    1
    >>> fib(3)
    2
    >>> fib(4)
    3
    >>> fib(5)
    5
    >>> fib(6)
    8
    >>> fib(100)
    354224848179261915075
    """
    "*** YOUR CODE HERE ***"
    i = 0
    j = 1
    ctr = 2
    if(n == 0):
        return 0
    elif(n == 1):
        return 1
    else:
        while(ctr <= n):
            result = j + i
            i = j
            j = result
            ctr = ctr + 1
        return j
def _test():
    import doctest
    doctest.testmod(verbose=True)

if __name__ == "__main__":
    _test()
