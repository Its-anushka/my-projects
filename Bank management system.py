
def enter_rec(det):
  id=input("Enter Customer Id")
  nm=input("Enter Customer name")
  cb=float(input("Enter cash balance"))
  pin=int(input("Generate Pin"))
  l=[id,nm,cb,pin]
  det.append(l)
  print("Your record was successfully updated!")

def id_rec(det):
    l=[]
    for i in det:
        l.append(i[0])
    return l
        
    
def records(det,rec):
    for i in det:
        if i not in rec:
          lis=[]
          for j in range(3):
              lis.append(i[j])
          rec.append(lis)
    return rec
            
def cash_withdrawal(det,l):
  id=input("Enter customer Id")
  if id in l:
      amt=int(input("Enter amount"))
      pin=int(input("Enter your pin"))
      for i in det:
          if id==i[0] and pin == int(i[3]):
              print("Collect your cash, your balance amount is", i[2]-amt)
              break
          else:
              print("Wrong pin entered")
              break
  else:
      print("Invalid Id")
def show_rec(rec,l):
  id=input("Enter your customer id")
  if id in l:
      for i in rec:
          if i[0]==id:
              print(i)
              break
  else:
      print("Invalid id")

def change_pin(det,l):
   id=input("Enter your customer id")
   if id in l:
       op=input("Enter old pin")
       np=input("Enter new pin")
       cp=input("Confirm new pin")
       for i in det:
           if i[0]==id:
               i[3]=cp
               print("Pin successfully changed!")
   else:
       print("invalid id")
   
det=[["123","Anushka",56231.90, "0704"],["125","Priya",79845,"1003"],["456","Diya",56321,"2809"]]
rec=[]
rec=records(det,rec)
print("\t\t*************BANK MANAGEMENT SYSTEM************** \t\t\t\t\t\t\t\t\n")

flag=True
while flag == True:
    l=id_rec(det)
    ch=input("(1)Enter a record[A]\n(2)View details[B]\n(3)Cash withdrawal[C]\n(4)Change pin[D]\nEnter your choice(A/B/C/D)")
    if ch == "A" or ch == "a":
      enter_rec(det)
      records(det,rec)
      id_rec(det)
      
    elif ch=="B" or ch == "b":
        show_rec(rec,l)

    elif ch == "C" or ch == "c":
        cash_withdrawal(det,l)

    elif ch == "D" or ch == "d":
        change_pin(det,l)
    else:
        print("Invalid input!")

    re=input("\nDo you want to re-enter your choice?(Y/N)")
    if re=="y" or re=="Y":
         flag = True
    elif re == "N" or re=="n":
         print("THANKS FOR VISITING! DO VISIT US AGAIN!")
         flag = False
    else:
         print("Invalid input")
         break


  

      
