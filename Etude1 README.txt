This program relies on a singular java array which partitions the user input data into Array elements. These elements including Day, Month and Year, are then processed with their individual method calls. With the parameters passed into static java methods checkDay(), checkMonth, checkYear(). The Date is processed using check statements and when all checks pass validation. The boolean Flags will be passed into a final if statement which will output the date entered by the user.

Test Cases:

1)
Input: 
16 Jun 3010

Output: 
Date: 03 Jun 3010
 - INVALID: Year entered incorrectly (Year of entry is outside valid range).

2) 
Input: 
09 Apr 1981

Output:
Date: 09 Apr 1981

3)
Input: 
11 Aug 1881

Output:
Date: 11 Aug 1881

4)
Input:
21 Oct 1987

Output:
21 Oct 1987

5)
Input:
--Nov-2134

Output:
Date: --Nov-2134
 - INVALID: Entry is not a date

6)
Input:
30 Feb 2000

Output:
Date: 30 Feb 2000
 - INVALID - Date entered is incorrect(FEB cannot exceed 29 days)

7)
Input: 0-Mar-2300

Output:
Date: 0-Mar-2300
 - INVALID: Date formatted incorrectly (day character cannot be 0).

8) 
Input: 
81-ABC-2567

Output:
Date: 81-ABC-2567
 - INVALID: Date formatted incorrectly (day character exceeds 31st day).
 - INVALID: Month formatted incorrectly (Month characters label not valid).

9)
Input: 
qrtp 9asdhfjh 

Output:
Date: qrtp 9asdhfjh
 - INVALID: Date formatted incorrectly (Seperator characters missing, date not readable).
 - INVALID: Date formatted incorrectly (day is not numerical).
 - INVALID: Entry is not a date

10)
Input:
1234567 12345 1234

Output:
Date: 1234567 12345 1234
 - INVALID: Date formatted incorrectly (day character exceeds 31st day).
 - INVALID: Date formatted incorrectly (Month character length exceeded).
 - INVALID: Date formatted incorrectly (Month character exceeds 12th month).
 - INVALID: Year entered incorrectly (Year of entry is outside valid range).

11)
Input:
1234567 12345-1234

Output:
Date: 1234567 12345-1234
 - INVALID: Date formatted incorrectly (Seperator characters missing, date not readable).
 - INVALID: Date formatted incorrectly (day character exceeds 31st day).
 - INVALID: Date formatted incorrectly (Month character length exceeded).
 - INVALID: Entry is not a date

12)
Input:
1234567 12345-1234-0987654321

Output:
Date: 1234567 12345-1234-0987654321
 - INVALID: Date formatted incorrectly (Seperator characters missing, date not readable).
 - INVALID: Date formatted incorrectly (day character exceeds 31st day).
 - INVALID: Date formatted incorrectly (Month character length exceeded).
 - INVALID: Entry is not a date

13)
Input:
17 Feb 2001  

Output:
Date: 17 Feb 2001

14)
Input:
29 Feb 2001 

Output:
Date: 29 Feb 2001
 - INVALID - Date entered is incorre

15)
Input: 
29 Feb 2200

Date: 29 Feb 2200
 - INVALID - Date entered is incorrect(The 29th of FEB is not within a leap year.)

16) 
Input:
1 Jan 2002 

Output:
Date: 1 Jan 2002

17)
Input: 
5 dEC 2030

Output:
Date: 5 dEC 2030
 - INVALID: Month formatted

18)
Input:
5 JAn 2030 

Output:
Date: 5 JAn 2030
 - INVALID: Month formatted incorrectly (Month characters label not valid).

19)
Input:
05 Sep 2030 

Output:
Date: 05 Sep 2030

20)
Input:
05 009 2030

Output:
Date: 05 009 2030
 - INVALID: Date formatted incorrectly (Month character length exceeded).


21)
Input:
05 009 0001

Output:
Date: 05 009 0001
 - INVALID: Date formatted incorrectly (Month character length exceeded).
 - INVALID: Year entered incorrectly (Year of entry is outside valid range).


22)
Input:
000 09 2999

Output:
Date: 005 09 2999
 - INVALID: Date formatted incorrectly (day character length exceeded).
