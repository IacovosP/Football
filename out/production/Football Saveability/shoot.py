import numpy as np
import pandas as pd
from sklearn import linear_model
from sklearn.ensemble import RandomForestClassifier
from sklearn.ensemble import ExtraTreesClassifier
from sklearn.tree import DecisionTreeClassifier
from sklearn.neural_network import MLPClassifier
from sklearn import preprocessing
from sklearn.model_selection import train_test_split
from sklearn.model_selection import KFold
from sklearn.model_selection import cross_val_score
import random
import sys

print 'Argument Lists:', str(sys.argv[1])

f = pd.read_csv(open("D:/Users/Jackys/IdeaProjects/Football Saveability/angle_distance1.csv"),encoding='utf-8')

f_names =  (list(f))
f_names.pop(f_names.index("saved"))
print (f_names)



train,test= train_test_split(f[:],test_size=0.2,random_state=1)
train_data = pd.DataFrame(train,columns=f_names)
train_target = pd.DataFrame(train,columns=["saved"])
test_data = pd.DataFrame(test,columns=f_names)
test_target = pd.DataFrame(test,columns=["saved"])
pj = pd.DataFrame(test,columns=["id","saved","Probability"])

#print(test_data[:3])

single_d=pd.DataFrame(test[:1],columns=f_names)
single_t=pd.DataFrame(test[:1],columns=["saved"])
#clf = RandomForestClassifier(solver="adam",alpha=0.00001,hidden_layer_sizes=(72,21,11,5,3),learning_rate="constant",learning_rate_init=0.001,random_state=1)
clf = RandomForestClassifier(n_estimators=100,max_depth=None,min_samples_split=2,criterion="entropy",n_jobs=8,random_state=3,verbose=True)

raveledTrain_data = train_target.values.ravel()
clf.fit(train_data,raveledTrain_data)

pj = pd.DataFrame(test,columns=["id","saved"])


clf = clf.fit(train_data,raveledTrain_data)
q = clf.predict(test_data)


p = clf.predict_proba(test_data) 
print(test_data)

a = [1,58.5699577331543,52.0735359191895,48.8534812927246,5,3,3]
test_data_a = pd.DataFrame([a],columns=f_names)

#print(test_data_a)
print(clf.score(test_data,test_target))
print()
print(clf.predict_proba(test_data_a))

prob_loss = []
prob_win = []
wl = []
for g in range(0,p.shape[0]):
	prob_loss.append(p[g][0])
	prob_win.append(p[g][1])
	wl.append(q[g])
	#print(prob_loss[g]," | ",prob_win[g]," | ",wl[g])	
pj["ML_Saved"] = wl
pj["Prob_Saved"] = prob_loss
pj["Prob_Not"] = prob_win


#pj.to_csv("C:/WinPython-64/notebooks/Q1/savedd.csv",columns=["id","saved","ML_Saved","Prob_Saved","Prob_Not"],header=True)
