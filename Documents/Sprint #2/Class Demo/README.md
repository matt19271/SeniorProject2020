# Running a Convolutional Neural Network (CNN)

You will find three different neural networks that you can open in a notebook like Jupyter or Google's colab notebook. However, because running and training a convolutional neural network requries a significant amount of computation, it's a bit cumbersome for you to experience this code release directly. 

Nevertheless, if you want to run a CNN during the code presentation, you can run a small convolutional network, named Convolutional Neural Network, that classify handwritten digits. 

In addition, if you want to experience CNN that we built for our application to 
identify face shape, you can run them later at your convenience since it requires quite a bit of computational time depending on the machine. The dataset that I used to train can be found in the zip file. 

## Requirements if you want to run the code:
1. Install Anaconda (64-bit)
	https://www.anaconda.com/distribution/
	
---You should see an Anaconda Prompt available on your computer. You may need to search for it. When you find it follow the last two installations.

2. Install TensorFlow (We recommend using the GPU installation if your computer has one. If not opt for the cpu installation)
	Type "pip install tensorflow" in the anaconda command prompt.
	*If this does not work you can follow the instructions here for a more in depth installation.
		https://medium.com/intel-student-ambassadors/installing-tensorflow-on-windows-with-anaconda-af6fa6280a4b
3. Install Keras
	Type "pip install keras" in the anaconda command prompt.
	
4. Type "jupyter notebook" in the anaconda command prompt and search for the file. This opens the current drive you are in so make sure the files are saved in that respective drive.
5. Open the file and run! (It may take a second to do something as its beginning the CNN process!)

If this doesn't work feel free to email us at csulbteamspectre@gmail.com or try installing the following packages if they are missing (They should be included with anaconda).
1. BLAS library - for fast tensor operations
2. Python scientific suite: Numpy and matplotlib
3. HDF5
