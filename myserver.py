import sys
from ex3utils import Server

#Echo server class
class EchoMyServer(Server):
    #variable for number of clients

    clients = 0
    allUsers = {}

    def onStart(self):
        print "The server has started"

    def onMessage(self, socket, message):
        (command, sep, parameter) = message.strip().partition(' ')
        myMessage = parameter

        #What happens if a user wants to send a message to everybody
        if command == "notPM":
            myMessage = parameter

            #looping through clients
            for userK, users in self.allUsers.iteritems():
                users.send(socket.userName + "- " + myMessage)

        #What happens if a user wants to send a PM
        if command == "PM":
            (personInterested, sep, myMessage) = parameter.strip().partition(' ')
            socket.myPerson = personInterested

            #Looping through clients
            for userK, users in self.allUsers.iteritems():
                if socket.myPerson == users.userName:
                    users.send(socket.userName + "- " + myMessage)

        #What happens if a user wants to register
        if command == "REG":
            socket.userName = parameter
            socket.send("You are registered")

        return True

    def onStop(self):
        print "The server has stopped"

    def onConnect(self, socket):
        self.clients = self.clients + 1
        self.allUsers[self.clients] = socket
        socket.userName = "Noob"

        for userK, users in self.allUsers.iteritems():
            users.send("Hi! Welcome to the chat group")
            users.send("Commands: ")
            users.send("1. REG - for registering")
            users.send("2. notPM - for sending a message to everybody")
            users.send("3. PM - for sending a PM")
            users.send("A client has connected")

    def onDisconnect(self, socket):
        print "A client has disconnected"
        self.clients = self.clients - 1
        print "There are " + str(self.clients) + " clients now"

ip = sys.argv[1]
port = int(sys.argv[2])

server = EchoMyServer()

server.start(ip, port)
