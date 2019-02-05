def twenty_nineteen():
    """Come up with the most creative expression that evaluates to 2019,
    using only numbers and the +, *, and - operators.
 
    >>> twenty_nineteen()
    2019
    >>> twenty_nineteen() + twenty_nineteen()
    4038
    """
    return 2 * 1000 + 20 - 1
def _test():
    import doctest
    doctest.testmod(verbose=True)

if __name__ == "__main__":
    _test()
