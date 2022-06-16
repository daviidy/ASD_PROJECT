# Framework development
The project consisted a framework that will provide common operations for a banking system 
and a credit card application.
## Project screenshot
![screenshot](./screenshot0.png)
![screenshot](./screenshot1.png)
![screenshot](./screenshot2.png)
![screenshot](./screenshot3.png)

## <span class="emoji-outer emoji-sizer"><span class="emoji-inner" style="background: url(chrome-extension://immhpnclomdloikkpcefncmfgjbkojmh/emoji-data/sheet_apple_32.png);background-position:55.99294947121034% 16.039952996474735%;background-size:5418.75% 5418.75%" data-codepoints="1f528"></span></span> Built with

- Java
- Maven

## <span class="emoji-outer emoji-sizer"><span class="emoji-inner" style="background: url(chrome-extension://immhpnclomdloikkpcefncmfgjbkojmh/emoji-data/sheet_apple_32.png);background-position:67.97884841363103% 34.01880141010576%;background-size:5418.75% 5418.75%" data-codepoints="1f680"></span></span> Our Project

Our project can be found at https://github.com/daviidy/ASD_PROJECT


## To run the project in local

- make sure you have Maven and JDK 16+ installed in your computer
- clone the repository from here [repo link](https://github.com/daviidy/ASD_PROJECT)
- navigate in your terminal to the folder `ASD_PROJECT`
- open the project with IntelliJ or Eclipse or SpringToolSuite
- right-click on the pom.xml file located in the root of the project
- then click on Maven > Update the project

## Specifications

### Design the class diagram to a banking system with the following Use cases:
- Create a personal account 
- Create a Company account (checking or savings)
- Deposit money 
- Withdraw money 
- Add interest 
- Generate a report of accounts

### Design the class diagram for a Credit-Card processing system with the following use cases:
- Create a credit card account 
- Deposit money 
- Charge the account 
- Add interest 
- Generate monthly billing report

### Design a Framework for both of these applications.
The framework should abstract out all of the common operations between these two applications, and
others that would be similar in nature. The evaluation criteria for the project will be how well you have
captured common parts of the intended application domain(s) in the framework, and it's internal design via
patterns.

## Design patterns used

### Command Pattern

The IUIInvoker is the invoker (in contains all the buttons listeners such that, when the user clicks on a button,
it calls the execute method of the Command interface).
We have concrete commands that implements the Command interface (like the one for adding a personal account).
They also have a reference of the receiver (the concrete services).

### Observer Pattern

The AccountService is the subject that will notify the observers (IUIInvoker, UIStrategy, EmailSender).
It has the list of observers and use the notifyObservers() in the Subject Interface, to notify all the observers

### Strategy Pattern

We use the strategy pattern to encapsulate the family of behaviors for the views and the add interest algorithm.

## <span class="emoji-outer emoji-sizer"><span class="emoji-inner" style="background: url(chrome-extension://immhpnclomdloikkpcefncmfgjbkojmh/emoji-data/sheet_apple_32.png);background-position:34.01880141010576% 34.01880141010576%;background-size:5418.75% 5418.75%" data-codepoints="1f468-1f3fd-200d-1f4bb"></span></span> <span class="emoji-outer emoji-sizer"><span class="emoji-inner" style="background: url(chrome-extension://immhpnclomdloikkpcefncmfgjbkojmh/emoji-data/sheet_apple_32.png);background-position:34.01880141010576% 38.01410105757932%;background-size:5418.75% 5418.75%" data-codepoints="1f468-1f3ff-200d-1f4bb"></span></span> Creators

<span class="emoji-outer emoji-sizer"><span class="emoji-inner" style="background: url(chrome-extension://immhpnclomdloikkpcefncmfgjbkojmh/emoji-data/sheet_apple_32.png);background-position:30.0235017626322% 89.9529964747356%;background-size:5418.75% 5418.75%" data-codepoints="1f464"></span></span> **Author**

- Github: [@daviidy](https://github.com/daviidy)
- Twitter: [@davidyao3](https://twitter.com/DavidYao3)
- LinkedIn: [@daviidy](https://www.linkedin.com/in/david-yao-6bb95299/)
- Personal Website: [@daviidy](http://david-yao.com)

## <span class="emoji-outer emoji-sizer"><span class="emoji-inner" style="background: url(chrome-extension://immhpnclomdloikkpcefncmfgjbkojmh/emoji-data/sheet_apple_32.png);background-position:75.96944770857814% 46.00470035252644%;background-size:5418.75% 5418.75%" data-codepoints="1f91d"></span></span> Contributing

Contributions, issues and feature requests are welcome!

## Show your support

Give a <span class="emoji-outer emoji-sizer"><span class="emoji-inner" style="background: url(chrome-extension://immhpnclomdloikkpcefncmfgjbkojmh/emoji-data/sheet_apple_32.png);background-position:99.94124559341951% 53.99529964747356%;background-size:5418.75% 5418.75%" data-codepoints="2b50"></span></span>️ if you like this project!

## <span class="emoji-outer emoji-sizer"><span class="emoji-inner" style="background: url(chrome-extension://immhpnclomdloikkpcefncmfgjbkojmh/emoji-data/sheet_apple_32.png);background-position:51.99764982373678% 71.97414806110459%;background-size:5418.75% 5418.75%" data-codepoints="1f4dd"></span></span> License

This project is no licensed.
