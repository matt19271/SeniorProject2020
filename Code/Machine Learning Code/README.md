# Running a Convolutional Neural Network (CNN)

## Brief Description of Code

1. mnist_keras_handwritten_digit_classification:
The first neural network that I learnt to build that classifies handwritten digits in the MNIST dataset. 

2. Handwritten Digit Classification
The first convolutional neural network that is build that again classifies handwritten digits in the MNIST dataset. 

3. Cats_vs_Dogs_CNN

This is the more complex CNN tutorial from the book Deep Learning in Python that classifies images of cats and dogs. This covers everything needed to work on my own covent to classify face shape from data preprocessing of the image files to the combatting overfitting and more. 

4. Face Shape Custom Model face_shape_one
 First attempt to build a CNN that can classify 5 different face shapes. Here, I simply built a fairly simple model to see that it’s working.

5. Face Shape Inception V3 face_shape_one
Instead of building a CNN from scratch, I learnt to utilize the pretrained convent using feature extraction where I extract the features learnt by the pretrained conv base and then retrain my model on the classifier that I add on top of it.


6. Face Shape VGG16 model face_shape_one
I took the same approach as training a different pretrained convent using feature extraction. This is the model where I have achieved the highest accuracy so far (It’s in the range of 52-60%).

7. Face Shape VGG16 model face_shape
In my last model, I found that my model was overfitting since I only had 400 images to train. So, the best way I knew to overcome is by using a larger dataset, this time with 3,000 images. I took the same approach as I did in the previous model, but the accuracy is not better to my surprise. 

8. VGG16 with Data Augmentation face_shape_one
Thinking that perhaps the smaller dataset is more properly labelled than my larger dataset, I went to using the VGG16 pretrained convent. But this time, I utilized the pretrained convent using a different approach where I retrained some layers of the convolutional base. Knowing that my earlier model had a problem with overfitting, I augmented the dataset as well. Again, no improvement in accuracy.

9. InceptionV3 w Data Augmentation face_shape_one 
There is a research paper that reports that retraining some of the last layer of the InceptionV3 gave the best result for face shape classification. Since I have learnt how to do that, I tried that approach where I retrained the last two inception blocks. Again, no improvement in accuracy.


10. Mobile Net V2 model  face_shape
Since our group has decided to implement an Android application, I thought I would see if I can make use of the lightweight model that can be implemented on mobile. I use the approach of feature extraction on this pretrained convent. Although the accuracy of the model did not improve, it performs quite well for a model with smaller weights. 

11. Mobile Net model face_shape
This is just another model suitable for mobile devices. I use a feature extraction approach when using the pretrained convent.  I was just experimenting to see if it would work better. 
