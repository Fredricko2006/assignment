#include <iostream>
#include <climits>
class solution
{
public:
    int reverse(int x)
    {
        long long result = 0;
        while(x != 0)
        {
            int digit = x % 10;
            x /= 10;

            if (result > (long long)INT_MAX / 10 || (result == (long long)INT_MAX / 10 && digit > 7)) return 0;
            if (result >(long long) INT_MIN / 10 || (result == (long long)INT_MIN / 10 && digit > -8)) return 0;

            result = result * 10 + digit;
        }
        return result;
    }
};

int main()
{
    solution sol;

    std::cout <<"Enter an integer to reverse : ";
    int input;
    std::cin >> input;
    int output = sol.reverse(input);

    if (output == 0 && input != 0)
    {
        std::cout<<"Reversed integer overflows 32-bit signed int. "<<std::endl;
    }
    else
    {
        std::cout<<"Reversed integer: " << output << std::endl;
    }
    return 0;
}