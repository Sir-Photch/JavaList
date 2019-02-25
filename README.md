# JavaList
Java alternative to (ugly) ls-command on MacOS, and Linux

This was intentionally meant to help me with my Java skills, but I liked the idea of customizing my own kind of "Finder"
Its purpose is to make a less oldschool version of ls, with sorting by filetype and colors!

If you want to make this program executable from everywhere,
one way is to create a bash-script and place it in your /usr/local/bin folder (MacOS), 
I'll provide one here on Github. (see the JavaList file with no extension here on this Repository)

This is currently implemented for MacOS, and sucessfully tested on Raspbian and KDE Neon.

I WILL NOT
provide a compiled version of this (for your own safety!)

Clone this Repository and audit/compile it yourself. 
If you don't know what that means, google "javac"

**USAGE:**

Configured Bash-Script:
```
javalist
```
Not configured Bash-Script:
```
java /path/to/JavaList /path/to/directory/to/be/shown
```
you can also use Arguments:
```
--help --info
```



