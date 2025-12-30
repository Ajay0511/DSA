def NthRoot(n: int, m: int) -> int:
    # Write Your Code Here
    left = 0
    right = m//n + 1

    while(left<=right):
        mid = (left+right)//2
        ans = 1
        for i in range(1,n+1):
            ans*=mid
        if ans == m:
            return mid
        elif ans > m:
            right = mid-1
        else:
            left = mid+1
    
    return -1

    pass