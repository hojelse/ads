# Using algs4

#### Table of Contents
1. [Windows and Java - Option 1 - terminal command with manual classpath
](#windows-and-java---option-1---terminal-command-with-manual-classpath
)
2. [Windows and Java - Option 2 - terminal command with global classpath](#windows-and-java---option-2---terminal-command-with-global-classpath)
3. [Visual Studio Code and Java](#visual-studio-code-and-java)

## Windows and Java - Option 1 - terminal command with manual classpath

With this option you need to reference `algs4.jar` every time you want to run your program, using the command `java -cp algs4.jar MyProgram.java`

### 1. Folder structure

Place MyProgram.java and algs4.jar in the same folder, or maybe place algs4.jar in a library folder like this:

```
algs4-sample-project/
├─── lib/
│    └─── algs4.jar
├─── src/
│    └─── MyProgram.java
```
### 2. Import from algs4
Add this line to the top of your MyProgram.java file `import edu.princeton.cs.algs4.*;` to import all algs4 classes.

Or import just one class like `ìmport edu.princeton.cs.algs4.UF;`

### 3. Execute your program
Use the command `java -cp algs4.jar MyProgram.java` if they are in the same folder.

or change the path to `lib/algs4.jar` if you created a lib folder e.g.: `java -cp lib/algs4.jar MyProgram.java`

## Windows and Java - Option 2 - terminal command with global classpath

If you want to be able to import algs4 classes in any java file anywhere on your computer (globally), and use terminal command: `java MyProgram.java`, try this option.

### 1. Editing your Enviroment Variables

Navigate to Enviroment Variable on Windows 10 `Control Panel > System and Security > System > Advanced System Settings > Advanced > Environment Variables` to edit your environment variables

In the example below, replace `\path\to\jdk-1.2.3.4` with your actual path to your [java jdk](https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/latest)

Variable                | Value    
------------------------|----------
CLASSPATH               |   C:\path\to\algs4.jar
JAVA_HOME               |   C:\path\to\jdk-1.2.3.4\
path                    |   %JAVA_HOME%\bin\

The variables, *JAVA_HOME* and *path*, might already be set after installing java jdk.

On windows 10 it might look something like this:

![algs4classpaths.png](/images/algs4classpath.png)

### 2. Import from algs4
Add this line to the top of your MyProgram.java file `import edu.princeton.cs.algs4.*;` to import all algs4 classes.

Or import just one class like `import edu.princeton.cs.algs4.UF;`

### 3. Execute your program

Use command `java MyProgram.java`

## Visual Studio Code and Java

If you want to use a light weight IDE, as an alternative to IntelliJ, you might want to try VS Code

### 1. Install [VS Code](https://code.visualstudio.com/)

### 2. Create a folder structure

You can create a folder structure like this:
```
algs4-sample-project/
├─── lib/
│    └─── algs4.jar
├─── src/
│    └─── MyProgram.java
```

*See the algs4-sample-project directory as reference.*

### 3. Install [java extension pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

After installing, now you should get IntelliSense (code suggestions) within VS Code and you can use the UI or `F5 key` (default keybinding) to run your java program.

**If you get no IntelliSense/Autocomplete**

Try this in VS Code, press `ctrl+shift+p` and select the command `Java: Clean Java Language Server Workspace`.

**If VS Code doesn't recognize algs4 imports and classes**

make sure algs4.jar is under *referenced libraries* in the *java projects* tab in the explorer, like the image below. This will add a *.vscode* folder containing a file containing some pointer to the jar file.
```
.vscode/
├─── settings.json
algs4-sample-project/
├─── lib/
│    └─── algs4.jar
├─── src/
│    └─── MyProgram.java
```

![vscode.png](images/vscode.png)
