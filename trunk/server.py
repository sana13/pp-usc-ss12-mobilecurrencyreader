import socket, traceback
import os
import time

host = '207.151.224.26'
port = 8080

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
s.bind((host, port))

while 1:
    try:
	print "Waiting for the Client to Connect..."
	message, address = s.recvfrom(512000)
	filehandle = open("test.jpg", "wb")
	filehandle.write(message)
	filehandle.close()
#	os.system("match")
	os.system("notepad")
	filehandle = open("result.txt", "r")
	message1 = filehandle.read()
	filehandle.close()
#	os.remove('result.txt')
	print message1
	print "Got data from", address
	s.sendto(message1, address)
    except (KeyboardInterrupt, SystemExit):
        raise
    except:
        traceback.print_exc()