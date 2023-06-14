#include <iostream>
#include <string>
#include <fstream>
#include <conio.h>
#include <cctype>
#include <windows.h>
using namespace std;
void login ();
void mainmenu ();
void sub_menu_company_details();
void vehdetails ();
void sub_menu_manage_sales();
void logout ();
void exit ();
void sub_menu_vehicle();
void vehicle_booking();
void vehicle_availiability();
void car();
void cab ();
void van();
void bus();
void motorbike();
void threewheel ();
void dil();
void din();
struct tourmate

{
	char num [25];
	int id;
	char name [25];
	char model [25];
	char capasity [25];
	char clr [25];
	char cls [25];
	
};


int main ()
{  

login ();
mainmenu (); 
   
}

//____________________________________________________________________________________________________________________
// ################################################# User login ########################################################
//____________________________________________________________________________________________________________________

void login () //function login

        {  
        system("cls");
		 int count=0;
    system ("color 5E" );
	cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;

	cout<<"\t\t\t\t\t\t\t\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"<<endl;
	Sleep(200);
	cout<<endl;
	cout<<"\t\t\t\t\t\t\t\t******************************************"<<endl;
		Sleep(200);
		cout<<endl;
	cout<<"\t\t\t\t\t\t\t\t               WELCOME TO                  "<<endl;
		Sleep(200);
		cout<<endl;
	cout<<"\t\t\t\t\t\t\t\t******************************************"<<endl;
		Sleep(200);
		cout<<endl;
	cout<<"\t\t\t\t\t\t\t\t******************************************"<<endl;
		Sleep(200);
		cout<<endl;
	cout<<"\t\t\t\t\t\t\t\t               TOURMATE                      "<<endl;
		Sleep(200);
		cout<<endl;
	cout<<"\t\t\t\t\t\t\t\t******************************************"<<endl;
		Sleep(200);
		cout<<endl;
	cout<<"\t\t\t\t\t\t\t\t******************************************"<<endl;
		Sleep(200);
		cout<<endl;
	cout<<"\t\t\t\t\t\t\t\t              CAB SERVICE                     "<<endl;
		Sleep(200);
	cout<<"\t\t\t\t\t\t\t\t******************************************"<<endl;
		Sleep(200);
		cout<<endl;
	cout<<"\t\t\t\t\t\t\t\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"<<endl;
	
	Sleep(200);	
	cout<<endl;
	cout<<endl;
    cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;	
		
		
		
		
		cout<<"\tL";
		Sleep (100);
		cout<<"o";
		Sleep (100);
		cout<<"a";
		Sleep (100);
		cout<<"d";
		Sleep (100);
		cout<<"i";
		Sleep (100);
		cout<<"n";
		Sleep (100);
		cout<<"g";
		Sleep (100);
		cout<<".";
		Sleep (100);
		cout<<".";
		Sleep (100);
		cout<<".";
		Sleep (100);
	
	
        	
        	
		system("cls");

        string un;
        string pw;

        cout<<endl; cout<<endl; cout<<endl; cout<<endl;


        cout <<"\t############################################################# \t USER LOGIN \t ############################################################ "<<endl;  
        cout <<"\t############################################################################################################################################# "<<endl;

        cout<<endl;
        cout<<endl;
        cout<<endl;
        cout<<endl;
        cout<<endl;
        cout<<"\t\t\t\t\t\t\t\t\t\t\t\t\t\t [HINT                         ]"<<endl;
        cout<<"\t\t\t\t\t\t\t\t\t\t\t\t\t\t [Username - admin             ]"<<endl;
        cout<<"\t\t\t\t\t\t\t\t\t\t\t\t\t\t [Password - from 4 to 1       ]"<<endl;
        cout<<endl;
        cout<<endl;
        cout<<endl;
 
        cout<< "\t\t\t\t\t\t Input user name\t\t:\t\t";
        cin>>un;
        cout<<endl;
        cout<<" \t\t\t\t\t\t Input password\t\t\t:\t\t";
        cin>>pw;
        cout<<endl;
        cout<<endl;
        
 
            if((un=="admin")&&(pw=="4321")) 

                {
                    system ("cls");
                    cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;  
 	                cout<<" \t\t\t\t\t\t\t\t   .......LOGIN SUCCESSFUL......" <<endl;
 	                cout<<endl;
 	                cout<<endl;
 	                cout<<endl;
                    cout<<" \t\t\t\t\t\t\t.......WELCOME TO THE TOUR MATE CAB SERVICE......"<<endl;
                    Sleep (2000);
                    mainmenu ();
			    }   
 
                else
                   {
                        for(int i=1; i<=2; i=i+1)
                         
						{
							   	   
						 
                            system ("cls"); 
                            cout<<endl;
                            cout<<endl;
                            cout<<endl;
                            cout<<endl;
  
                            cout <<"\t############################################################# \t USER LOGIN \t ############################################################ "<<endl;  
                            cout <<"\t############################################################################################################################################# "<<endl;


                            
                            cout<<endl;
                            cout<<endl;
                            cout<<endl;
                            cout<<endl;
                            cout<<" You're login is invalid "<<endl;
                            cout<<endl;
                            cout<<" PLEASE TRY AGAIN........"<<endl;
                            cout<<"\t\t\t\t\t\t\t\t\t\t\t\t\t\t [HINT                         ]"<<endl;
					        cout<<"\t\t\t\t\t\t\t\t\t\t\t\t\t\t [Username - admin             ]"<<endl;
					        cout<<"\t\t\t\t\t\t\t\t\t\t\t\t\t\t [Password - from 4 to 1       ]"<<endl;
                            cout<<endl;
                            cout<<endl;
                            cout<<endl;
   
	                        cout<< " \t\t\t\t\t\t Input user name\t\t:\t\t";
                            cin>>un;
                            cout<<endl;
                            cout<<" \t\t\t\t\t\t Input password\t\t\t:\t\t";
                            cin>>pw;
                            cout<<endl;
                                    
									
							if((un=="admin")&&(pw=="4321")) 
                                    {
									   int i;
										i=2;
   		
                                        system ("cls");
                                       cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;  
					 	                cout<<" \t\t\t\t\t\t\t\t   .......LOGIN SUCCESSFUL......" <<endl;
					 	                cout<<endl;
					 	                cout<<endl;
					 	                cout<<endl;
					                    cout<<" \t\t\t\t\t\t\t.......WELCOME TO THE TOUR MATE CAB SERVICE......"<<endl;
                                        Sleep (2000);
                                        mainmenu ();
		                            }
	 
 	
   	                                else

                                    { 
                                        system ("cls"); 
			                            cout<<endl;
			                            cout<<endl;
			                            cout<<endl;
			                            cout<<endl;
  
		                            cout <<"\t############################################################# \t USER LOGIN \t ############################################################ "<<endl;  
		                            cout <<"\t############################################################################################################################################# "<<endl;

			                            cout<<endl;
			                            cout<<endl;
			                            cout<<endl;
			                            cout<<endl;
			                            cout<<" You're login is invalid "<<endl;
			                            cout<<endl;
			                            cout<<" PLEASE TRY AGAIN........"<<endl;
			                            cout<<"\t\t\t\t\t\t\t\t\t\t\t\t\t\t [HINT                         ]"<<endl;
								        cout<<"\t\t\t\t\t\t\t\t\t\t\t\t\t\t [Username - admin             ]"<<endl;
								         cout<<"\t\t\t\t\t\t\t\t\t\t\t\t\t\t [Password - from 4 to 1       ]"<<endl;
			                            cout<<endl;
			                            cout<<endl;
			                            cout<<endl;
			   
				                        cout<<" \t\t\t\t\t\t Input user name\t\t:\t\t";
			                            cin>>un;
			                            cout<<endl;
			                            cout<<" \t\t\t\t\t\t Input password\t\t\t:\t\t";
			                            cin>>pw;
			                            cout<<endl;
                          
                                        
                                        }

                                            if((un=="admin")&&(pw=="4321"))
                                                {
													system ("cls");
                                                    cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;  
					 	                cout<<" \t\t\t\t\t\t\t\t   .......LOGIN SUCCESSFUL......" <<endl;
					 	                cout<<endl;
					 	                cout<<endl;
					 	                cout<<endl;
					                    cout<<" \t\t\t\t\t\t\t.......WELCOME TO THE TOUR MATE CAB SERVICE......"<<endl;
		                                   Sleep (2000);
		                                          mainmenu ();
                                                }
                                                    else
                                                        {

                                                            system ("cls");
                                                            cout<<endl;
                                                            cout<<endl;
                                                            cout<<endl;
                                                            cout<<endl;
                                                            cout<<" \t\t You can't log into the system "<<endl;
                                                            cout<<endl;
                                                            cout<<" \t\t You can try again. If you wait for a few seconds......"<<endl;	
                                                        
														}
                    
                   }
                   
                    
				}




Sleep (5000);

login ();

}


 //____________________________________________________________________________________________________________________
//############################################ Main menu ############################################################
//______________________________________________________________________________________________________________________
 
void mainmenu () //function main menu
{

system ("cls");

cout<<endl;
cout<<endl;
cout<<endl<<endl;

cout <<"\t############################################################# \t MAIN MENU \t ############################################################ "<<endl;  
cout <<"\t############################################################################################################################################# "<<endl;
      
cout<<endl;
cout<<endl;
cout<<endl<<endl<<endl<<endl;

cout<<"\t 1. View company details  "<<endl;
cout<<endl;
cout<<endl;
cout<<"\t 2. Vehicle details " <<endl;
cout<<endl;
cout<<endl;
cout<<"\t 3. Payment details " <<endl;
cout<<endl;
cout<<endl;
cout<<"\t 4. Vehicle Booking system "<<endl;
cout<<endl;
cout<<endl;
cout<<"\t 5. Vehicle Availiability "<<endl;
cout<<endl;
cout<<endl;
cout<<"\t 6. Logout "<<endl;
cout<<endl;
cout<<endl;
cout<<"\t 7. Exit  "<<endl; 
cout<<endl; 
cout<<endl<<endl<<endl;

int value;

	cout<<" SELECT ";
	cin>>value;

switch (value)

{
	case 1:sub_menu_company_details();
	
	break;
	    
	case 2:sub_menu_vehicle();
	
	break;
	    
	case 3:sub_menu_manage_sales();
	    
	break;
	    
	case 4:vehicle_booking(); 
	    
	break;
	    
	case 5:vehicle_availiability();
	system ("pause");
	mainmenu ();
	
	
	break;
	
	case 6:logout ();
		
	break;
	
	case 7:exit ();
		
	break;
	
	
	    
	default:cout<<" Invalid Input, Try again...  " <<endl;
	Sleep (1000);
    mainmenu ();
	}

    }
// NUMBER 01
//________________________________________________________________________________________________________________________
//######################################## MM.1. View company details #######################################################
//________________________________________________________________________________________________________________________

void sub_menu_company_details() // function  1.company details


    {

	system ("cls");
	
	cout<<endl;
	cout<<endl;
	cout<<endl;

	cout <<"\t############################################################# \t COMPANY DETAILS \t ############################################################ "<<endl;  
    cout <<"\t##################################################################################################################################################### "<<endl;

	cout<<endl<<endl<<endl<<endl<<endl<<endl;
   cout<<"\tCompany name\t - Tour Mate\n";
   cout<<endl;
   cout<<"\tLocation\t - Highlevel rd, Gangodawila, Nugegoda, Colombo\n ";
   cout<<endl;
   cout<<"\tNo of Employees\t - 100 Employees\n";
   cout<<endl;
   	cout<<"\tOwner name\t - Mr.Sanath perera\n ";
   cout<<endl;
   cout<<"\tOpen at \t - at 6.00 a.m\n ";
   cout<<endl;
   cout<<"\tClose at\t - at 10.00 p.m\n ";
   cout<<endl;
   cout<<"\tContact No\t - 0112784335 / 0775421047 / 0773545639\n ";
   cout<<endl;
   cout<<"\tE Mail\t\t - tourmatecabs@gmail.com";
   	cout<<endl<<endl<<endl<<endl<<endl<<endl;
    system ("pause");
     
	mainmenu ();
}


 // NUMBER 02
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void sub_menu_vehicle()
{  system ("cls");
		
    tourmate t;
	int a,b ;
	cout<<endl<<endl<<endl;
	cout <<"\t############################################################# \t VEHICLE DETAILS \t ############################################################ "<<endl;  
	cout <<"\t##################################################################################################################################################### "<<endl;

	cout<<endl<<endl<<endl;
	cout<<"\n\t 01. View Vehicle Details "<<endl;
	cout<<endl;
	cout<<"\n\t 02. Add Vehicle Details "<<endl;
	cout<<endl;
	cout<<"\n\t 03. Delete Vehicle Details "<<endl;
	cout<<endl;
	cout<<"\n\t 04. Update Vehicle Details "<<endl;
	cout<<endl;
	cout<<"\n\t 05. Go back "<<endl;
	cout<<endl;
	cout<<"\n\t 06. Exit "<<endl;
	cout<<endl;
	cout<<endl;
	cout<<" Select : ";
	cin>>a;
	
	switch (a)
	{ 
	    case 1:
			{
				system ("cls");
				cout<<endl;
			 	cout<<endl;
	   			cout <<"\t############################################################\t VIEW VEHICLE DETAILS \t########################################################## "<<endl;  
  
				ifstream xfile;
				xfile.open("orrg.txt");
				
				xfile>>t.id;	
				xfile>>t.num;
				xfile>>t.name;	
				xfile>>t.model;	
				xfile>>t.capasity;	
				xfile>>t.clr;	
				xfile>>t.cls;		
				
				while (!xfile.eof()) 			
				{
		 			cout<<"\n\t Vehicle Index No		: "<<t.id;
		 			cout<<"\n\t Vehicle No 			: "<<t.num;
		 			cout<<"\n\t Vehicle type 			: "<<t.name;
		  			cout<<"\n\t Vehicle model			: "<<t.model;
		 			cout<<"\n\t Capasity 			: "<<t.capasity;
		 			cout<<"\n\t Vehicle colour 		: "<<t.clr;
		 			cout<<"\n\t Vehicle Class 			: "<<t.cls;
		 			cout<<endl;
		 			
		 			
		 			xfile>>t.id;	
		 			xfile>>t.num;
		 			xfile>>t.name;	
		 			xfile>>t.model;	
		 			xfile>>t.capasity;	
		 			xfile>>t.clr;	
		 			xfile>>t.cls;
		 		}		
		 		xfile.close() ;
                
				system ("pause");
                sub_menu_vehicle();
				   
			    break;
			} 
			 
	   case 2:
	   	
	   	    {  ///////////////////////////////////////////////////////////////
	           
		   		system ("cls");
		  
		   		cout<<endl<<endl<<endl;
		  		cout <<"\t############################################################# \t ADD VEHICLE DETAILS \t ############################################################ "<<endl;  
  				cout<<endl<<endl<<endl;
	   
		   
		   		cout<<endl<<endl<<endl<<endl<<endl<<endl;
		   		loop:
			    int h;
		   	    cout<<"\tDo you want ADD records ?"<<endl;
		   	    cout<<endl<<endl;
		   	    cout<<"\t\t01. Yes"<<endl;
		   	    cout<<"\t\t02. No"<<endl;
		   	    cout<<endl<<endl;
		   	    cout<<"\tSelect ";
		   	    cin>>h;
	   	  
	   	      		switch (h)
	   	  
						{
	   	   				case 1: 
	   	  						{
			 
		  
		     						system ("cls");
		     
		     	
							   		cout<<endl<<endl<<endl;
								    cout <<"\t############################################################# \t ADD VEHICLE DETAILS \t ############################################################ "<<endl;  
						  			cout<<endl<<endl<<endl;
							   
							   		cout<<"\n\t 1.) Vehicle Index No	(Ex : 1,2,3...)				: ";
							   		cin>>t.id;
							   		cout<<"\n\t 2.) Vehicle No		(Ex : ABC1234/ABC_1234) 		: ";
							   		cin>>t.num;
							   		cout<<"\n\t 3.) Vehicle type	(Ex : Car,Van,Cab...) 			: ";
							   		cin>>t.name;
							   		cout<<"\n\t 4.) Vehicle model	(Ex : Toyota,Mitsubishi...)		: ";
							   		cin>>t.model;
							   		cout<<"\n\t 5.) Capasity 							: ";
							   		cin>>t.capasity;
							   		cout<<"\n\t 6.) Vehicle colour 						: ";
							   		cin>>t.clr;
							   		cout<<"\n\t 7.) Vehicle Class	(Ex : Auto/Manual) 			: ";
							   		cin>>t.cls;
						   	    	cout<<endl;
							   		
							   		
							   		ofstream yfile;
							   		yfile.open("orrg.txt",ios::app);
							   		
							   		
							   		yfile<<endl;
							   		yfile<<t.id;
									yfile<<endl;	
									yfile<<t.num;
									yfile<<endl;
									yfile<<t.name;
									yfile<<endl;	
									yfile<<t.model;
									yfile<<endl;	
									yfile<<t.capasity;
									yfile<<endl;	
									yfile<<t.clr;
									yfile<<endl;	
									yfile<<t.cls;
									yfile<<endl;
									
			
		    						yfile.close() ;
		    /////////////////////////////////////////////////////////////////////////////////
		    ////////////////////////////////booking/////////////////////////////////////////
								    ofstream bkfile;
								    bkfile.open("orrj.txt",ios::app);
								    
								    bkfile<<endl;
							   		bkfile<<t.id;
									bkfile<<endl;	
									bkfile<<t.num;
									bkfile<<endl;
									bkfile<<t.name;
									bkfile<<endl;	
									bkfile<<t.model;
									bkfile<<endl;	
									bkfile<<t.capasity;
									bkfile<<endl;	
									bkfile<<t.clr;
									bkfile<<endl;	
									bkfile<<t.cls;
									bkfile<<endl;
									
									
									bkfile.close() ;
			///////////////////////////////////////////////////////////////////////////////////////////////////
							 		int v;
							 		cout<<endl<<endl;
							 		cout<<" Done ! "<<endl;
							 		Sleep(500);
							 		cout<<endl;
							 		cout<<" You added record SuCCeSSfUl... "<<endl;
							 		Sleep(700);
							 		cout<<endl;
							 		cout<<"\tMORE OVER, "<<endl;
							 		 
							 		 goto loop;
		    
		     						break;
     							}
     
		  			 	case 2:
		   						{
								   sub_menu_vehicle();
								   break;
	       						}
	
					    default:
								   	cout<<" Invalid input, Try again..."<<endl;
								   	Sleep (1000);
								   	system ("cls");
								   	cout<<endl<<endl<<endl;
									cout <<"\t############################################################# \t ADD VEHICLE DETAILS \t ############################################################ "<<endl;  
									cout<<endl<<endl<<endl;
								   	cout<<endl<<endl<<endl<<endl<<endl<<endl;
								   
	   	   							goto loop;
		     	            break;
						}
		   
           }
		
		case 3 :
		/////////////////////////////////////////////////////////////////////////////////////////////
			 
			{  
				system ("cls"); 
				cout<<endl<<endl<<endl;
				cout<<endl<<endl<<endl;
			   	cout <<"\t############################################################# \t DELETE VEHICLE DETAILS \t ############################################################ "<<endl;  
	  	        cout<<endl;
				cout<<endl;
				cout<<"\tDo you want to delete this records ?"<<endl;
				cout<<endl;
				cout<<"\t\t01. Yes "<<endl;
				cout<<"\t\t02. No "<<endl;
				cout<<endl<<endl;
				cout<<"\tSelect "<<endl;
				int x;
				cin>>x;
			
					switch (x)
						{
							case 1: 
								{
				
									system ("cls");
									cout<<endl<<endl<<endl;
									cout<<endl<<endl<<endl;
							   		cout <<"\t############################################################# \t DELETE VEHICLE DETAILS \t ############################################################ "<<endl;  
						  	        cout<<endl<<endl<<endl;
		
									int b; int e;
									cout<<"\t\tEnter ID number want to delete : ";
									cin >> b;
									ifstream udfile;
									udfile.open("orrg.txt");
									ofstream tfile;
									tfile.open("ntfiixd.txt");
			       
									udfile>>t.id;	
									udfile>>t.num;
									udfile>>t.name;	
									udfile>>t.model;	
									udfile>>t.capasity;	
									udfile>>t.clr;	
									udfile>>t.cls;
				    
									while (!udfile.eof())
										{
											if (t.id!=b)
											
												{
												    tfile<<t.id<<endl;	
													tfile<<t.num<<endl;
													tfile<<t.name<<endl;	
													tfile<<t.model<<endl;	
													tfile<<t.capasity<<endl;	
													tfile<<t.clr<<endl;	
													tfile<<t.cls<<endl;
												}
											
											else
											
												{
													e=1;
												}
				 
											udfile>>t.id;	
											udfile>>t.num;
											udfile>>t.name;	
											udfile>>t.model;	
											udfile>>t.capasity;	
											udfile>>t.clr;	
											udfile>>t.cls;
				
										}
										
									tfile.close() ;
									udfile.close() ;
									remove ("orrg.txt");
									rename ("ntfiixd.txt", "orrg.txt");
									
									if(e==1)
										{
											cout<<"\n Records DELETED \n";
										}
									else if(e!=1)
											cout<<"\n Records NOT \n";
			/////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////booking delete///////////////////////////////////////
									ifstream budfile;
									budfile.open("orrj.txt");
									ofstream btfile;
									btfile.open("ntfiixxd.txt");
									       
									budfile>>t.id;	
									budfile>>t.num;
									budfile>>t.name;	
									budfile>>t.model;	
									budfile>>t.capasity;	
									budfile>>t.clr;	
									budfile>>t.cls;
				    
									while (!budfile.eof())
										{
											if (t.id!=b)
												{
												    btfile<<t.id<<endl;	
													btfile<<t.num<<endl;
													btfile<<t.name<<endl;	
													btfile<<t.model<<endl;	
													btfile<<t.capasity<<endl;	
													btfile<<t.clr<<endl;	
													btfile<<t.cls<<endl;
												}
											else
												{
													e=1;
												}
				 
											budfile>>t.id;	
											budfile>>t.num;
											budfile>>t.name;	
											budfile>>t.model;	
											budfile>>t.capasity;	
											budfile>>t.clr;	
											budfile>>t.cls;
				
										}
									btfile.close() ;
									budfile.close() ;
									remove ("orrj.txt");
									rename ("ntfiixxd.txt", "orrj.txt");
									if(e==1)
										{
											cout<<"\n\t SUCCESSFULY ! \n";
										}
									else if(e!=1)
											cout<<"\n\t FOUND !!! \n";
											
		                            cout<<endl<<endl<<endl;	
									system ("pause");
									sub_menu_vehicle();
				
								break;
				
								}
								
							case 2: 
								{
									sub_menu_vehicle();
								break;
								}
			
							default: 
								
								
								cout<<" Invalid input, Log again..."<<endl;
									Sleep (1000);
									system ("pause");
									system ("cls");
			                    	sub_menu_vehicle();
								
		
						}
			  
				break;
			
			}
			
			case 4:
			
			{ 	
				system ("cls");
			
				cout<<endl<<endl<<endl;
			   	cout <<"\t############################################################# \t UPDATE VEHICLE DETAILS \t ############################################################ "<<endl;  
		  		cout<<endl;
				cout<<endl;
				cout<<endl;
			
				cout<<"\tDo you want to update this records ?"<<endl;
				cout<<endl;
				cout<<"\t\t01. Yes "<<endl;
				cout<<"\t\t02. No "<<endl;
				cout<<endl<<endl;
				cout<<"\tSelect "<<endl;
				int y;
				cin>>y;
			
					switch (y)
						{
			
							case 1:
								{
									system ("cls");
									cout<<endl<<endl<<endl;
						   			cout <<"\t############################################################# \t UPDATE VEHICLE DETAILS \t ############################################################ "<<endl;  
					  				cout<<endl;
									cout<<endl;
									cout<<endl;	
									int b; int e;
									cout<<" Enter the ID number you want update :";
									cin>>b;
									ifstream udfile;
									udfile.open("orrg.txt");
									ofstream tfile;
									tfile.open("ntfiixd.txt");
									
									ifstream budfile;
									budfile.open("orrj.txt");
									ofstream btfile;
									btfile.open("ntfiixxd.txt");      
			       
									udfile>>t.id;	
									udfile>>t.num;
									udfile>>t.name;	
									udfile>>t.model;	
									udfile>>t.capasity;	
									udfile>>t.clr;	
									udfile>>t.cls;
									
									budfile>>t.id;	
									budfile>>t.num;
									budfile>>t.name;	
									budfile>>t.model;	
									budfile>>t.capasity;	
									budfile>>t.clr;	
									budfile>>t.cls;
				    
									while (!udfile.eof())
									while (!budfile.eof())
									
										{
											if (t.id!=b)
												{
												    tfile<<t.id<<endl;	
													tfile<<t.num<<endl;
													tfile<<t.name<<endl;	
													tfile<<t.model<<endl;	
													tfile<<t.capasity<<endl;	
													tfile<<t.clr<<endl;	
													tfile<<t.cls<<endl;
													
													btfile<<t.id<<endl;	
													btfile<<t.num<<endl;
													btfile<<t.name<<endl;	
													btfile<<t.model<<endl;	
													btfile<<t.capasity<<endl;	
													btfile<<t.clr<<endl;	
													btfile<<t.cls<<endl;
													
												}
												
											else
												{
													int w; char x[25]; char y[25]; char z[25]; char t[25]; char h[25]; char k[25];
													cout<<"\n\t Vehicle Index No			: ";
											   		cin>>w;
											   		cout<<"\n\t Vehicle No 				: ";
											   		cin>>x;
											   		cout<<"\n\t Vehicle type 				: ";
											   		cin>>y;
											   		cout<<"\n\t Vehicle model				: ";
											   		cin>>z;
											   		cout<<"\n\t Capasity 				: ";
											   		cin>>t;
											   		cout<<"\n\t Vehicle colour 			: ";
											   		cin>>h;
											   		cout<<"\n\t Vehicle Class 				: ";
											   		cin>>k;
			   		
											   		tfile<<w<<endl;	
													tfile<<x<<endl;
													tfile<<y<<endl;	
													tfile<<z<<endl;	
													tfile<<t<<endl;	
													tfile<<h<<endl;
													tfile<<k<<endl<<endl;
													e=1;
													
													btfile<<w<<endl;	
													btfile<<x<<endl;
													btfile<<y<<endl;	
													btfile<<z<<endl;	
													btfile<<t<<endl;	
													btfile<<h<<endl;
													btfile<<k<<endl<<endl;
													e=1;
												}
				 
											udfile>>t.id;	
											udfile>>t.num;
											udfile>>t.name;	
											udfile>>t.model;	
											udfile>>t.capasity;	
											udfile>>t.clr;	
											udfile>>t.cls;
											
											budfile>>t.id;	
											budfile>>t.num;
											budfile>>t.name;	
											budfile>>t.model;	
											budfile>>t.capasity;	
											budfile>>t.clr;	
											budfile>>t.cls;
										}
			
			
									tfile.close() ;
									udfile.close() ;
									remove ("orrg.txt");
									rename ("ntfiixd.txt", "orrg.txt");
									if(e==1)
									
										{
											cout<<"\n RECORDS UPDATED \n";
										}
										
									else if(e!=1)
											cout<<"\n RECORDS NOT \n";
				
									btfile.close() ;
									budfile.close() ;
									remove ("orrj.txt");
									rename ("ntfiixxd.txt", "orrj.txt");
									if(e==1)
									
										{
											cout<<"\n\t SUCCESSFULLY ! \n";
										}
										
									else if(e!=1)
											cout<<"\n\t FOUND !!! \n";
									cout<<endl<<endl<<endl;			    
			   						system ("pause");
			     					sub_menu_vehicle();
			     					
								break;
								}
								
			 				case 2: 
			 				
			 					{
									 
									 sub_menu_vehicle();
									 break;
								}
		
							default:
									
								   
									cout<<" Invalid input, Log again..."<<endl;
									Sleep (1000);
									system ("pause");
									system ("cls");
			                    	sub_menu_vehicle();
								
								
								
								
								
									
						}
			}
			
			
		case 5:
			
			{
			
					mainmenu ();
				break;
            }
            
       case 6:
       	
       	{
       		    exit ();
       		break;
       		
		}
		   
        default:
			cout<<" Invalid Input, Try again...  " <<endl;
	        Sleep (1500);
            sub_menu_vehicle();
	
	}//close the switch curly bracket
}//close the sub menu function curly bracket

 
//____________________________________________________________________________________________________________________
// ########################################## MM.3. Payment details ################################################
//____________________________________________________________________________________________________________________


void sub_menu_manage_sales() //function 3.manage sales details

{
system ("cls");
cout<<endl;
cout<<endl;
cout<<endl;
cout<<endl;
		
	   cout <<"\t############################################################# \t PAYMENT DETAILS \t ############################################################ "<<endl;  
  	   cout <<"\t##################################################################################################################################################### "<<endl;

	  cout<<endl;
	cout<<endl;
	int x;
	cout<<" First You Have to SELECT the vehicle which you rent from TOURMATE CAB service  "<<endl;
	cout<<endl<<endl;
	cout<<" (01). Car "<<endl;
	cout<<endl;
	cout<<" (02). Cab "<<endl;
	cout<<endl;
	cout<<" (03). Van "<<endl;
	cout<<endl;
	cout<<" (04). Bus "<<endl;
	cout<<endl;
	cout<<" (05). Motor Bike "<<endl;
	cout<<endl;
	cout<<" (06). ThreeWheel "<<endl;
	cout<<endl;
	cout<<" (07). Go back Main menu "<<endl;
	cout<<endl;
	
	cout<<" Select : ";
	cin>>x;
	
	switch (x)
	{
		case 1: car();
		break;
		
		case 2:cab ();
		break;
		
		case 3:van();
		break;
		
		case 4:bus();
		break;
		
		case 5:motorbike();
		break;
		
		case 6:threewheel();
		break;
		
		case 7:mainmenu();
		break; 
		
		default: cout<<" Invalid input "<<endl;
			Sleep (1000);
			sub_menu_manage_sales();
	}

}
//Number 03
//_________________________________________________________________________________________________________________
//############################################## Vehicle Booking ###################################################
//________________________________________________________________________________________________________________


void vehicle_booking()
{  
	          
			    int h;
			    
			    system ("cls");
			     tourmate t;
		   		cout<<endl<<endl;
			    cout <<"\t######################################################### \t VEHICLE BOOKING SYSTEM \t ############################################################### "<<endl;  
 	
				cout<<endl<<endl<<endl<<endl<<endl;
			
			    cout<<endl<<endl;
				cout<<"\tDo you really want BOOKING vehicles ?"<<endl;
		   	    cout<<endl<<endl;
		   	    cout<<"\t\t01. Yes"<<endl;
		   	    cout<<"\t\t02. No"<<endl;
		   	    cout<<endl<<endl;
		   	    cout<<"\tSelect ";
		   	    cin>>h;
	   	  		switch (h)
	   	  		
	   	  		{
		   	  				
				
				
			   	case 1 :
				{ cout<<endl<<endl<<endl;
				
				cout<<" Then you should CHOOSE any kind of vehicle from 'AVAILABLE VEHICLE DETAILS' "<<endl;
				cout<<endl<<endl<<endl;
			    system ("pause");
			    system ("cls");
			    vehicle_availiability();
				system ("pause");
			    
		   		cout<<endl<<endl;
			    cout <<"\t########################################################### \t VEHICLE BOOKING DETAILS \t ###################################################################### "<<endl;  
	 	
				cout<<endl<<endl<<endl<<endl<<endl;
				cout<<"* Input relevent vehicle details"<<endl;
		   	    cout<<endl;
		   	    cout<<endl;
		   	    cout<<endl;
		   		cout<<"\n\t 1.) Vehicle Index No	(Ex : 1,2,3...)				: ";
		   		cin>>t.id;
		   		cout<<"\n\t 2.) Vehicle No		(Ex : ABC1234/ABC_1234) 		: ";
		   		cin>>t.num;
		   		cout<<"\n\t 3.) Vehicle type	(Ex : Car,Van,Cab...) 			: ";
		   		cin>>t.name;
		   		cout<<"\n\t 4.) Vehicle model	(Ex : Toyota,Mitsubishi...)		: ";
		   		cin>>t.model;
		   		cout<<"\n\t 5.) Capasity 							: ";
		   		cin>>t.capasity;
		   		cout<<"\n\t 6.) Vehicle colour 						: ";
		   		cin>>t.clr;
		   		cout<<"\n\t 7.) Vehicle Class	(Ex : Auto/Manual) 			: ";
		   		cin>>t.cls;
	   	    	cout<<endl;
	   	    	
	   	    	cout<<"\n\t Record BOOKED SuCCeSSfUl...";
			   		Sleep(1500);
		   		ofstream yfile;
		   		yfile.open("bookingfile.txt",ios::app);
		   		
		   		yfile<<endl;
		   		yfile<<t.id;
				yfile<<endl;	
				yfile<<t.num;
				yfile<<endl;
				yfile<<t.name;
				yfile<<endl;	
				yfile<<t.model;
				yfile<<endl;	
				yfile<<t.capasity;
				yfile<<endl;	
				yfile<<t.clr;
				yfile<<endl;	
				yfile<<t.cls;
				yfile<<endl;
				
			    yfile.close() ;
			    break;
		    
		   
		   system ("pause");
		   
		}
		case 2: 
				{
					system ("cls");
					mainmenu ();
					break;
				}
	
		default:
			cout<<" Invalid Input, Log again..."<<endl;
			Sleep(1200);
		    system ("pause");
		    vehicle_booking();
		 // break;  
	}//switch h close
		    	   
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//REMOVE DEtails

            loop:
			system ("cls");
			cout<<endl<<endl<<endl;
			cout <<"\t############################################################# \t REMOVE VEHICLE DETAILS \t ############################################################ "<<endl;  
 			cout<<endl;
			cout<<endl;
			cout<<" * You should remove that vehicle record from the availble details. Enter your booked vehicle number in here"<<endl;
			cout<<endl<<endl<<endl;
			
			int b; int e;
		
			cout<<"\t Enter ID number that you booked recently : ";
			cin >> b;
			ifstream budfile;
			budfile.open("orrj.txt");
			ofstream btfile;
			btfile.open("ntfiixxd.txt");
			       
			budfile>>t.id;	
			budfile>>t.num;
			budfile>>t.name;	
			budfile>>t.model;	
			budfile>>t.capasity;	
			budfile>>t.clr;	
			budfile>>t.cls;
				    
			while (!budfile.eof())
			{
				if (t.id!=b)
				{
				    btfile<<t.id<<endl;	
					btfile<<t.num<<endl;
					btfile<<t.name<<endl;	
					btfile<<t.model<<endl;	
					btfile<<t.capasity<<endl;	
					btfile<<t.clr<<endl;	
					btfile<<t.cls<<endl;
				}
				else
				{
					e=1;
				}
				 
				budfile>>t.id;	
				budfile>>t.num;
				budfile>>t.name;	
				budfile>>t.model;	
				budfile>>t.capasity;	
				budfile>>t.clr;	
				budfile>>t.cls;
				
			}
			btfile.close() ;
			budfile.close() ;
			remove ("orrj.txt");////////////////////////
			rename ("ntfiixxd.txt", "orrj.txt");/////////////////////////
			if(e==1)
			{
				cout<<endl<<endl;
				cout<<"\n\t Record REMOVED Successfully \n";
			
			}
			
			else if(e!=1)
			{
			
				cout<<endl<<endl<<endl;
				cout<<"\n\t Record NOT FOUND ! \n";
				Sleep (1500);
				
				goto loop;
		   }
		   
			system ("pause");
			vehicle_booking();
			
				 }//available close		    
						    	

//_________________________________________________________________________________________________
//######################################## Vehicle Availiability ##########################################
//_____________________________________________________________________________________________________


void vehicle_availiability()

{
	
				system ("cls");
				tourmate t;
				cout<<endl;
			 cout <<"\t############################################################# \t AVAILABLE VEHICLE DETAILS \t ############################################################ "<<endl;  
  			 cout <<"\t############################################################################################################################################################# "<<endl;
	
								
				ifstream xfile;
				xfile.open("orrj.txt");
				xfile>>t.id;	
				xfile>>t.num;
				xfile>>t.name;	
				xfile>>t.model;	
				xfile>>t.capasity;	
				xfile>>t.clr;	
				xfile>>t.cls;		
				
				while (!xfile.eof()) 			
				{
					cout<<"\n\t Vehicle Index No		: "<<t.id;
					cout<<"\n\t Vehicle No 			: "<<t.num;
					cout<<"\n\t Vehicle type 			: "<<t.name;
					cout<<"\n\t Vehicle model			: "<<t.model;
					cout<<"\n\t Capasity 			: "<<t.capasity;
					cout<<"\n\t Vehicle colour 		: "<<t.clr;
					cout<<"\n\t Vehicle Class 			: "<<t.cls;
					cout<<endl;
					
					
					xfile>>t.id;	
					xfile>>t.num;
					xfile>>t.name;	
					xfile>>t.model;	
					xfile>>t.capasity;	
					xfile>>t.clr;	
					xfile>>t.cls;
				}		
				xfile.close() ;
		
}


//____________________________________________________________________________________________________________________
// ############################################# MM.4. Log out #########################################################
//____________________________________________________________________________________________________________________

void logout ()//function 4. logout 
{system ("cls");
	cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;
		
cout <<"\t############################################################# \t LOGOUT \t ############################################################ "<<endl;  
cout <<"\t############################################################################################################################################# "<<endl;

  	cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;
	
	cout<<" Do you really want to log out " <<endl;
	
	{
	int letter;
	cout<<endl;
	cout<<"\t (01) Yes " <<endl;
	cout<<endl;
	cout<<"\t (02) No"<<endl;
	cout<<endl;
   	cin>>letter;
   	switch (letter)
	{
	
	case 1 :login ();
	break; 
		
	case 2:mainmenu ();
	break;
		 
	default:cout<<" Invalid Input, Try again... "<<endl;
    Sleep (1500);
	logout ();
		    
	}
}
	
	 
}
//__________________________________________________________________________________________________________________________
//############################################## MM 5. EXIT ###############################################################
//_____________________________________________________________________________________________________________________________
 
void exit () //function 5.Exit

{
    system ("cls");
	cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;
		
cout <<"\t############################################################# \t EXIT \t ############################################################ "<<endl;  
cout <<"\t##################################################################################################################################### "<<endl;
 
  	cout<<endl;
	cout<<endl;
	cout<<endl;
	cout<<endl;
		
	cout<<endl;
	
	int ex;
	cout<<"\t (01) Do you really want to EXIT "<<endl;
	cout<<endl;
	cout<<endl;
	cout<<"\t (02) Or you can back to the main menu\n";
	cout<<endl;
	cout<<"\t Select : ";
	cin>>ex;
 
 switch (ex) 
 {
 	case 1:exit (0);
 	break ;
 	
 	case 2:mainmenu ();
 	break ;
 	
 	default:cout<<" Invalid Input, Try again... "<<endl; 
 	Sleep (1500);
 	
	exit ();
 	
 }
 }
 
 void car()
{
	system ("cls");
	cout<<endl<<endl;
	cout<<" |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| CAR |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| "<<endl;
	cout<<endl<<endl<<endl;
	cout<<"\t.*. We charge 180 Rupees per 1KM for any variety of cars which have in our company, "<<endl;

	int d;
	int t;
	cout<<endl<<endl<<endl<<endl;
	cout<<"Enter the distance you travelled (KM)\t: ";
	cin>>d;
	cout<<endl<<endl<<endl<<endl<<endl;
	 Sleep(1000);
	 cout<<"\t\t\t\t\t\t\t Payment"<<endl;
	 Sleep(1000);
	 cout<<"\t\t\t\t\t\t\t\t Is"<<endl;
	 Sleep(1000);
	 cout<<"\t\t\t\t\t\t\t\t   Creating";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 system ("cls");
	 
	t=d*180;
	 cout<<endl<<endl<<endl<<endl<<endl;
	 cout<<"\t\t\t\t\t\t\t\tYOU'RE PAYMENT BILL IS HERE"<<endl;
	 cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	 cout<<"\t\t\t\t\t\t#################################################################"<<endl;
	 Sleep(500);
	 cout<<"\t\t\t\t\t\t#\t- Your Vehicle type is \t\t - Car\t\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t- You had gone \t\t\t - "<<d<<" Kilometers\t#"<<endl;	
	 cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t- You have to pay \t\t - "<<"Rs. "<<t<<".00\t\t#"<<endl;
	 Sleep(500);
     cout<<"\t\t\t\t\t\t#################################################################"<<endl;
     
     cout<<endl<<endl<<endl;
     Sleep(500);
	system ("pause");
	sub_menu_manage_sales();
	
}

void cab ()
{
system ("cls");
	cout<<endl<<endl;
	cout<<" |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| CAB |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| "<<endl;
	cout<<endl<<endl<<endl;
	cout<<"\t.*. We charge 200 Rupees per 1KM for any variety of cabs which have in our company, "<<endl;

	int d;
	int t;
	cout<<endl<<endl<<endl<<endl;
	cout<<"Enter the distance you travelled(KM)\t: ";
	cin>>d;
	cout<<endl<<endl<<endl<<endl<<endl;
	Sleep(1000);
	cout<<"\t\t\t\t\t\t\t Payment"<<endl;
	Sleep(1000);
	cout<<"\t\t\t\t\t\t\t\t Is"<<endl;
	Sleep(1000);
	cout<<"\t\t\t\t\t\t\t\t   Creating";
	Sleep(1000);
	cout<<".";
	Sleep(1000);
	cout<<".";
	Sleep(1000);
	cout<<".";
	Sleep(1000);
	system ("cls");
	 
	t=d*200;
	cout<<endl<<endl<<endl<<endl<<endl;
	cout<<"\t\t\t\t\t\t\t\tYOU'RE PAYMENT BILL IS HERE"<<endl;
	cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	cout<<"\t\t\t\t\t\t#################################################################"<<endl;
	Sleep(500);
	cout<<"\t\t\t\t\t\t#\t- Your Vehicle type is \t\t - Cab\t\t\t#"<<endl;
	cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	cout<<"\t\t\t\t\t\t#\t- You had gone \t\t\t - "<<d<<" Kilometers\t#"<<endl;	
	cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	cout<<"\t\t\t\t\t\t#\t- You have to pay \t\t - "<<"Rs. "<<t<<".00\t\t#"<<endl;
	Sleep(500);
    cout<<"\t\t\t\t\t\t#################################################################"<<endl;
     
	cout<<endl<<endl<<endl;
    Sleep(500);
	system ("pause");
	sub_menu_manage_sales();
}

void van()
{
 system ("cls");
	cout<<endl<<endl;
	cout<<" |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| VAN |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| "<<endl;
	cout<<endl<<endl<<endl;
	cout<<"\t.*. We charge 150 Rupees per 1KM for any variety of Vans which have in our company, "<<endl;

	int d;
	int t;
	cout<<endl<<endl<<endl<<endl;
	cout<<"Enter the distance you travelled(KM)\t: ";
	cin>>d;
	cout<<endl<<endl<<endl<<endl<<endl;
	Sleep(1000);
	cout<<"\t\t\t\t\t\t\t Payment"<<endl;
	Sleep(1000);
	cout<<"\t\t\t\t\t\t\t\t Is"<<endl;
	Sleep(1000);
	cout<<"\t\t\t\t\t\t\t\t   Creating";
	Sleep(1000);
	cout<<".";
	Sleep(1000);
	cout<<".";
	Sleep(1000);
	cout<<".";
	Sleep(1000);
	system ("cls");
	 
	t=d*150;
	cout<<endl<<endl<<endl<<endl<<endl;
	cout<<"\t\t\t\t\t\t\t\tYOU'RE PAYMENT BILL IS HERE"<<endl;
	cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	cout<<"\t\t\t\t\t\t#################################################################"<<endl;
	Sleep(500);
	cout<<"\t\t\t\t\t\t#\t- Your Vehicle type is \t\t - Van\t\t\t#"<<endl;
	cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	cout<<"\t\t\t\t\t\t#\t- You had gone \t\t\t - "<<d<<" Kilometers\t#"<<endl;	
	cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	cout<<"\t\t\t\t\t\t#\t- You have to pay \t\t - "<<"Rs. "<<t<<".00\t\t#"<<endl;
	Sleep(500);
    cout<<"\t\t\t\t\t\t#################################################################"<<endl;
 
 	cout<<endl<<endl<<endl;
    Sleep(500);
	system ("pause");
	sub_menu_manage_sales();
}

void bus ()
{
 	system ("cls");
	cout<<endl<<endl;
	cout<<" |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| BUS |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| "<<endl;
	cout<<endl<<endl<<endl;
	cout<<"\t.*. We charge 80 Rupees per 1KM for any variety of cabs which have in our company, "<<endl;

	int d;
	int t;
	cout<<endl<<endl<<endl<<endl;
	cout<<"Enter the distance you travelled(KM)\t: ";
	cin>>d;
	cout<<endl<<endl<<endl<<endl<<endl;
	Sleep(1000);
	cout<<"\t\t\t\t\t\t\t Payment"<<endl;
	Sleep(1000);
	 cout<<"\t\t\t\t\t\t\t\t Is"<<endl;
	 Sleep(1000);
	 cout<<"\t\t\t\t\t\t\t\t   Creating";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 system ("cls");
	 
	t=d*80;
	 cout<<endl<<endl<<endl<<endl<<endl;
	 cout<<"\t\t\t\t\t\t\t\tYOU'RE PAYMENT BILL IS HERE"<<endl;
	 cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	 cout<<"\t\t\t\t\t\t#################################################################"<<endl;
	 Sleep(500);
	 cout<<"\t\t\t\t\t\t#\t- Your Vehicle type is \t\t - Cab\t\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t- You had gone \t\t\t - "<<d<<" Kilometers\t#"<<endl;	
	 cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t- You have to pay \t\t - "<<"Rs. "<<t<<".00\t\t#"<<endl;
	 Sleep(500);
     cout<<"\t\t\t\t\t\t#################################################################"<<endl;

	cout<<endl<<endl<<endl;
     Sleep(500);
	system ("pause");
	sub_menu_manage_sales();
}


void motorbike()
{
	system ("cls");
	cout<<endl<<endl;
	cout<<" |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| MOTOR BIKE |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| "<<endl;
	cout<<endl<<endl<<endl;
	cout<<"\t.*. We charge 100 Rupees per 1KM for any variety of Motor bikes which have in our company, "<<endl;

	int d;
	int t;
	cout<<endl<<endl<<endl<<endl;
	cout<<"Enter the distance you travelled(KM)\t: ";
	cin>>d;
cout<<endl<<endl<<endl<<endl<<endl;
	 Sleep(1000);
	 cout<<"\t\t\t\t\t\t\t Payment"<<endl;
	 Sleep(1000);
	 cout<<"\t\t\t\t\t\t\t\t Is"<<endl;
	 Sleep(1000);
	 cout<<"\t\t\t\t\t\t\t\t   Creating";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 system ("cls");
	 
	t=d*100;
	 cout<<endl<<endl<<endl<<endl<<endl;
	 cout<<"\t\t\t\t\t\t\t\tYOU'RE PAYMENT BILL IS HERE"<<endl;
	 cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	 cout<<"\t\t\t\t\t\t#################################################################"<<endl;
	 Sleep(500);
	 cout<<"\t\t\t\t\t\t#\t- Your Vehicle type is \t\t - Motor Bike\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t- You had gone \t\t\t - "<<d<<" Kilometers\t#"<<endl;	
	 cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t- You have to pay \t\t - "<<"Rs. "<<t<<".00\t\t#"<<endl;
	 Sleep(500);
     cout<<"\t\t\t\t\t\t#################################################################"<<endl;

	cout<<endl<<endl<<endl;
     Sleep(500);
	system ("pause");
	sub_menu_manage_sales();
}

void threewheel ()
{
	system ("cls");
	cout<<endl<<endl;
	cout<<" |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| THREEWHEEL |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| "<<endl;
	cout<<endl<<endl<<endl;
	cout<<"\t.*. We charge 60 Rupees per 1KM for any variety of Threewheel which have in our company, "<<endl;

	int d;
	int t;
	cout<<endl<<endl<<endl<<endl;
	cout<<"Enter the distance you travelled(KM)\t: ";
	cin>>d;
cout<<endl<<endl<<endl<<endl<<endl;
	 Sleep(1000);
	 cout<<"\t\t\t\t\t\t\t Payment"<<endl;
	 Sleep(1000);
	 cout<<"\t\t\t\t\t\t\t\t Is"<<endl;
	 Sleep(1000);
	 cout<<"\t\t\t\t\t\t\t\t   Creating";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 cout<<".";
	 Sleep(1000);
	 system ("cls");
	 
	t=d*60;
	 cout<<endl<<endl<<endl<<endl<<endl;
	 cout<<"\t\t\t\t\t\t\t\tYOU'RE PAYMENT BILL IS HERE"<<endl;
	 cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	 cout<<"\t\t\t\t\t\t#################################################################"<<endl;
	 Sleep(500);
	 cout<<"\t\t\t\t\t\t#\t- Your Vehicle type is \t\t - Threewheel\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t- You had gone \t\t\t - "<<d<<" Kilometers\t#"<<endl;	
	 cout<<"\t\t\t\t\t\t#\t\t\t\t\t\t\t\t#"<<endl;
	 cout<<"\t\t\t\t\t\t#\t- You have to pay \t\t - "<<"Rs. "<<t<<".00\t\t#"<<endl;
	 Sleep(500);
     cout<<"\t\t\t\t\t\t#################################################################"<<endl;
     
	cout<<endl<<endl<<endl;
     Sleep(500);
	system ("pause");
	sub_menu_manage_sales();

}

