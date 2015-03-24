# Mobile Currency Reader #
<br />


## Overview ##

<p>
This mobile currency reader project intends to make tasks such as recognizing the values of different dollar bills easier for visually impaired people. The application will first prompt users to capture an image of the holding bill, and the captured image will be transferred to the server. Then the server will process the image in order to recognize the value of the bill. Once the value of the bill is determined, the server will select the appropriate audio file to play to the users.<br>
</p>
<p>
It is important to note that we designed the project with the assumption that the user is aware that the bank note is a dollar bill, and has the ability to get hold of an Android phone whether through their own power or the help from others.<br>
</p>

---


## Pre-requisites ##
  1. Android SDK starter package<br />
  1. Android Plugin for Eclipse - Android emulator for testing the code.
<br />
**See useful links for intros on how to install these.

---

## Technical Overview ##
Since Android is one of the most popular mobile phones nowadays, our group decided to code the mobile currency reader project primarily for Android platform.**

Below is a simple description of the application’s major functions:
  1. The Android phone captures an image of a bank note and writes it to buffer.
  1. The captured image is then sent to the server.
  1. The image is processed for recognizing the value of the bill
  1. The result of image recognition is used to select corresponding audio file.
  1. The chosen audio file is sent back to the phone and played to the user.

<img src='http://i204.photobucket.com/albums/bb76/tina_chen/diagram-1.png' />
<img src='http://i204.photobucket.com/albums/bb76/tina_chen/ss12_mobile_img1.png' />
<img src='http://i204.photobucket.com/albums/bb76/tina_chen/ss12_mobile_img3.png' />

#### Acquiring Image from Phone and Writing to Buffer ####
The first step in the application is to acquire image of the bill. For our prototype,
the user interface is fairly straight-forward - allowing the user to take a snap shot of a
Dollar bank note. At first, we simply downloaded the code for a simple Camera Demo off
the internet (see below). We soon encountered the problem that we did not know what the simulator is
taking a photo of, since the simulator does not use the web cam as the actual camera of an
android phone. Once the user takes the picture, the Java application turns the image into
a byte array.

#### Recognizing the Denomination ####
The server matches the features of submitted images against a library of stored features of different denomination and create a score for each comparison. It will then return the comparison with the highest score. The comparison is done using the scale-invariant feature transform algorithm (SIFT). We used only object recognition and robotic mapping and navigation from SIFT in this project. These basically make all the images we take in have the same orientation, scale and rotation. Note that this takes care of possible problems such as viewing the banknote from an angle, or viewing a crumpled bill.

<img src='http://i204.photobucket.com/albums/bb76/tina_chen/ImageRecognition-1.jpg' />

#### Outputting Text to Audio Files ####
Once the server determines the denomination of the bill, the next thing to do is to convert the result into audible files. Currently, we create actual audio files for each denomination of bills. This means that once the server finishes recognizing the denomination, it will then select the corresponding audio file and play it to the user.

<br />

---

## Future Improvement ##

  1. Currently, it is built primarily for Android users. In the future, it can be modified to adapt with different mobile platforms.
  1. The application now only supports English and one voice. Support to multiple languages and various voices would be valuable to the growth of the project.
  1. Apprarently, even though the application can detect the value of the different dollar bills, it cannot distinguish between a genuine and a fake banknote.
<br />

---

## Useful Links ##

<a href='http://developer.android.com/reference/packages.html'>Android API</a><br />
<a href='http://marakana.com/forums/android/android_examples/39.html'>Camera Demo</a><br />
<a href='http://en.wikipedia.org/wiki/Scale-invariant_feature_transform'>Scale-Invariant Feature Transform</a>

<br />