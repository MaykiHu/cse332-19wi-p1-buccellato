# Project 1 (Zip) Write-Up #

## Project Feedback ##
### How Was Your Partnership? ###
- How was your partnership? What worked well? What would you do differently next time?

<blockquote>
TODO: Answer this question
</blockquote>

- Did both partners do an equal amount of work?  If not, why not? If so, what did each person do? What happened?

<blockquote>
TODO: Answer this question
</blockquote>

### Project Enjoyment ###
- What was your favorite part of the project?  What was your least favorite part of the project 

<blockquote>
TODO: Answer this question
</blockquote>

- Did you enjoy the project?  Why or why not?

<blockquote>
TODO: Answer this question
</blockquote>

- How could the project be improved?

<blockquote>
TODO: Answer this question
</blockquote>

-----

## WorkLists ##
### WorkList Interface ###
We've implemented several data structures that all share the WorkList interface. What is the advantage of having several data structures with the same interface? Why not give each of them their own interface?

<blockquote>
TODO: Answer this question
</blockquote>

## Tries ##
### TrieMap vs. (HashMap and TreeMap) ###
As we've described it, a `TrieMap` seems like a general-purpose replacement for `HashMap` or `TreeMap`. Why might we still want to use one of these other data structures instead?

<blockquote>
TODO: Answer this question
</blockquote>

### Applications of TrieMap ###
One of the applications of Tries is in solving Word Searches.  A "word search" is an n x m rectangle of letters.  The goal is to find all of the possible words (horizontal, vertical, diagonal, etc.).  In Boggle, a similar game, any consecutive chain of letters are allowed.  Explain (in very high-level pseudo-code) how you might solve this problem with a TrieSet or a TrieMap.  Make sure to detail how a similar solution that uses a HashSet/HashMap instead would be different and why using a Trie might make the solution better.

<blockquote>
TODO: Answer this question
</blockquote>

## Zip ##
For this part of the write-up:
- You'll need a working SuffixTrie to run the ZIP experiments for this writeup.  Implementing SuffixTrie yourself is part of the Above & Beyond section and not required for full credit.  To use our provided SuffixTrie.jar (if you don't want to implement it yourself), right click on SuffixTrie.java in the Eclipse sidebar, choose Refactor > Rename, and name it something else (like SuffixTrieUnused.java) **with "update references" unchecked**. <br>
- Put your test files in the root directory of the project (that is, **at the same level as src**, not in the src folder).

### Running Zip ###
One of the classes in the main package is called Zip. This class uses your PriorityQueue to do Huffman coding, your FIFOQueue as a buffer, your stack to calculate the keyset of a trie (using recursive backtracking), and your SuffixTrie to do LZ77Compression. Find some text file (a free book from https://www.gutenberg.org/ or even the HTML of some website) and use Zip.java to zip it into a zip file. Then, use a standard zip utility on your machine (Finder on OS X, zip on Linux, WinZip or the like on Windows) to UNZIP your file. Check that you got back the original. Congratulations! Your program correctly implements the same compression algorithm you have been using for years! Discuss in a sentence or two how good the compression was and why you think it was good or bad.

<blockquote>
TODO: Answer this question
</blockquote>

### Zip Experiment ###
Now that you've played with Zip, we want you to do an **experiment** with Zip. <br>

Notice that there is a constant called `BUFFER_LENGTH` in `Zip.java`. Higher values of this constant makes the compression algorithm that Zip uses use more memory and consequently more time. The "compression ratio" of a file is the uncompressed size divided by the compressed size. <br>

Compare time, type of input file, and compression ratio by running your code on various inputs.  We would like an in-depth analysis. 
- You should try at least one "book-like" file, at least one "website-like" file, and some other input of your choice. 
- You should also vary the `BUFFER_LENGTH` constant for each of these inputs.
- You should run multiple trials for each data point to help remove outliers.

We expect you to draw meaningful conclusions and have tables or graphs that convince us of your conclusions. In particular, you should explain WHY you think you may have gotten the results you did. <br>

This single question is worth almost as much as the implementation of `ArrayStack`; so, please take it seriously.  If you spend less than 20 minutes on this question, there is no conceivable way that you answered this question in the way we were intending.

<blockquote>
TODO: Answer this question
</blockquote>

----

## Above and Beyond ##
Did you do any Above and Beyond?  Describe exactly what you implemented.

<blockquote>
TODO: Answer this question
</blockquote>
