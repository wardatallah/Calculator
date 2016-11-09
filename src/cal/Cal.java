/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ITner
 */
public class Cal extends JFrame implements ActionListener
{   
    String last;
    boolean num=false,oper=true,equ=false,bnum1=false,bnum2=false,beq=false,del=false; 
    /*
     * num : didn't add a number yet
     * oper : didn't add a operation yet
     * equ : 
     */
    int num1=0,num2=0,res=0;
    JLabel lb1,lb2,lb3;
    JTextField txNum,txRes,txOp;
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bm,bt,bd,be,bclear,bdel;
    JPanel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9;
    
    Cal(){
        setTitle("Calculator");
        JOptionPane.showMessageDialog(null, "Welcome in ITner's Calculator\n\nPlz, do it right :D\n ");
        
        lb3=new JLabel("Operation :");
        txOp=new JTextField(15);
        lb1=new JLabel("Number\t  :");
        txNum=new JTextField(15);
        lb2=new JLabel("Resault\t  :");
        txRes=new JTextField(15);
        
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");
        b0=new JButton("0");
        ba=new JButton("+");
        bm=new JButton("-");
        bt=new JButton("*");
        bd=new JButton("/");
        be=new JButton("=");
        bclear=new JButton("   C   ");
        bdel=new JButton("  Del  ");
        
        p0=new JPanel(new FlowLayout());
        p1=new JPanel(new FlowLayout());
        p2=new JPanel(new FlowLayout());
        p3=new JPanel(new FlowLayout());
        p4=new JPanel(new FlowLayout());
        p5=new JPanel(new FlowLayout());
        p6=new JPanel(new FlowLayout());
        p7=new JPanel(new FlowLayout());
        p8=new JPanel(new FlowLayout());
        p9=new JPanel(new FlowLayout());
        
        p0.add(lb3);
        p0.add(txOp);
        p1.add(lb1);
        p1.add(txNum);
        p2.add(lb2);
        p2.add(txRes);
        p4.add(b1);
        p4.add(b2);
        p4.add(b3);
        p5.add(b4);
        p5.add(b5);
        p5.add(b6);
        p6.add(b7);
        p6.add(b8);
        p6.add(b9);
        p7.add(ba);
        p7.add(b0);
        p7.add(bm);
        p8.add(bt);
        p8.add(bd);
        p8.add(be);
        p9.add(bclear);
        p9.add(bdel);
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        getContentPane().add(p0);
        getContentPane().add(p1);
        getContentPane().add(p2);
        getContentPane().add(p3);
        getContentPane().add(p4);
        getContentPane().add(p5);
        getContentPane().add(p6);
        getContentPane().add(p7);
        getContentPane().add(p8);
        getContentPane().add(p9);
         
        
        b1.setActionCommand("one");
        b2.setActionCommand("two");
        b3.setActionCommand("three");
        b4.setActionCommand("four");
        b5.setActionCommand("five");
        b6.setActionCommand("six");
        b7.setActionCommand("seven");
        b8.setActionCommand("eight");
        b9.setActionCommand("nine");
        b0.setActionCommand("zero");
        ba.setActionCommand("add");
        bm.setActionCommand("minus");
        bt.setActionCommand("times");
        bd.setActionCommand("divide");
        be.setActionCommand("equal");
        bclear.setActionCommand("clear");
        bdel.setActionCommand("delete");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        ba.addActionListener(this);
        bm.addActionListener(this);
        bt.addActionListener(this);
        bd.addActionListener(this);
        be.addActionListener(this);
        bclear.addActionListener(this);
        bdel.addActionListener(this);
        
        txOp.setEditable(false);
        txRes.setEditable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cal c=new Cal();
        c.pack();
        c.setResizable(false);
        c.setVisible(true);
        c.setLocation(550, 250);
       
    }
    

    @Override
    public void actionPerformed(ActionEvent e){
        
        switch (e.getActionCommand()) {
            case "clear":{
                        num1=0;num2=0;res=0;
                        num=false;oper=true;equ=false;bnum1=false;bnum2=false;beq=false;del=false;
                        txNum.setText("");
                        txRes.setText("");
                        txOp.setText("");
                    }
                break;
            
                
                case "delete":{
                    String sTemp;
                    int iTemp,len1;
                        if(oper){
                            if(txOp.getText().length()!=0){
                            sTemp=txOp.getText();
                            len1=sTemp.length();
                            sTemp=sTemp.substring(0, len1-1);
                            txOp.setText(sTemp);
                            oper=false;
                            del=true;
                            }
                        }
                        else{
                            if(txNum.getText().length()==0);
                            else{
                                sTemp=txNum.getText();
                                iTemp=Integer.parseInt(sTemp);
                                iTemp=iTemp/10;
                                if(iTemp!=0){
                                sTemp=Integer.toString(iTemp);
                                txNum.setText(sTemp);
                                }
                                else
                                txNum.setText("");
                            }
                        }
                    }
                break;
                    
                
            case "one":
                if(num==false){
                 txNum.setText(txNum.getText()+ "1");
                 oper=false;
                     if(bnum1==true){
                         bnum2=true;
                     }
                         }
                break;
                
                
            case "two":
                if(num==false){
                 txNum.setText(txNum.getText()+ "2");
                 oper=false;
                     if(bnum1==true){
                         bnum2=true;
                     }
                         }
                break;
                
                
            case "three":
                if(num==false){
                 txNum.setText(txNum.getText()+ "3");
                 oper=false;
                     if(bnum1==true){
                         bnum2=true;
                     }
                         }
                break;
                
                
            case "four":
                if(num==false){
                 txNum.setText(txNum.getText()+ "4");
                 oper=false;
                     if(bnum1==true){
                         bnum2=true;
                     }
                         }
                break;
                
                
            case "five":
                if(num==false){
                 txNum.setText(txNum.getText()+ "5");
                 oper=false;
                     if(bnum1==true){
                         bnum2=true;
                     }
                         }
                break;
                
                
            case "six":
                if(num==false){
                 txNum.setText(txNum.getText()+ "6");
                 oper=false;
                     if(bnum1==true){
                         bnum2=true;
                     }
                         }
                break;
                
                
            case "seven":
                if(num==false){
                 txNum.setText(txNum.getText()+ "7");
                 oper=false;
                     if(bnum1==true){
                         bnum2=true;
                     }
                         }
                break;
                
                
            case "eight":
                if(num==false){
                 txNum.setText(txNum.getText()+ "8");
                 oper=false;
                     if(bnum1==true){
                         bnum2=true;
                     }
                         }
                break;
                
                
            case "nine":
                if(num==false){
                 txNum.setText(txNum.getText()+ "9");
                 oper=false;
                  if(bnum1==true){
                         bnum2=true;
                     }
                         }
                break;
                
                
            case "zero":
                if(num==false){
                 txNum.setText(txNum.getText()+ "0");
                 oper=false;
                     if(bnum1==true){
                         bnum2=true;
                     }
                         }
                break;
                
                
            case "add":// Start of ADD actionperformed
                if (oper==false){
                    if(!del){
                     if (!beq){
                    if(!bnum1){
                         num1= Integer.parseInt(txNum.getText());
                         txOp.setText(txNum.getText()+ "+");
                         txNum.setText("");
                         last="add";
                         oper=true;
                         num=false;
                         bnum1=true;
                    }
                    else{
                         num2=Integer.parseInt(txNum.getText());
                         doIt(last);
                         num1=res;
                         txOp.setText(num1+"+");
                         txNum.setText("");
                         last="add";
                         oper=true;
                         num=false;
                    }
                  }
                else
                     {
                     txOp.setText(num1+"+");
                     last="add";
                     oper=true;
                     num=false;
                     beq=false;
                     }
                }
                    else{
                    txOp.setText(txOp.getText()+"+");
                    last="add";
                    oper=true;
                    num=false;
                    }
             }
                else
                {
                    if (bnum1){
                     txOp.setText(num1+"+");
                     last="add";
                     oper=true;
                     num=false;
                     beq=false;
                    }
                    else
                    JOptionPane.showMessageDialog(null, "Please enter a number first !");
                }
                break;// End of ADD actionperformed
                
                
            case "minus":// Start of MINUS actionperformed
                if (oper==false){
                    if(!del){
                    if(!beq){
                if(!bnum1){
                        num1= Integer.parseInt(txNum.getText());
                        txOp.setText(txNum.getText()+ "-");
                        txNum.setText("");
                        last="minus";
                        oper=true;
                        num=false;
                        bnum1=true;
                   }
                   else{    
                        num2=Integer.parseInt(txNum.getText());
                        doIt(last);
                        num1=res;
                        txOp.setText(num1+"-");
                        txNum.setText("");
                        last="minus";
                        oper=true;
                        num=false;
                   }
                }
                else
                    {
                    txOp.setText(num1+"-");
                    last="minus";
                    oper=true;
                    num=false;
                    beq=false;
                    }
                }
                else
                    {
                   if (bnum1){
                    txOp.setText(num1+"-");
                    last="minus";
                    oper=true;
                    num=false;
                    beq=false;
                   }
                   else
                   JOptionPane.showMessageDialog(null, "Please enter a number first !"); 
               }
         }
                else
                {
                    if (bnum1){
                     txOp.setText(num1+"-");
                     last="minus";
                     oper=true;
                     num=false;
                     beq=false;
                    }
                    else
                    JOptionPane.showMessageDialog(null, "Please enter a number first !");
                }
                break;// End of MINUS actionperformed
                
                
            case "times":// START of TIMES actionperformed
                if (oper==false){
                  if(!del){
                    if (!beq){
                       if(!bnum1){
                         num1= Integer.parseInt(txNum.getText());
                         txOp.setText(txNum.getText()+ "*");
                         txNum.setText("");
                         last="times";
                         oper=true;
                         num=false;
                         bnum1=true;
                         }
                    else{
                         num2=Integer.parseInt(txNum.getText());
                         doIt(last);
                         num1=res;
                         txOp.setText(num1+"*");
                         txNum.setText("");
                         last="times";
                         oper=true;
                         num=false;
                         }
                    }
                 else
                     {
                     txOp.setText(num1+"*");
                     last="times";
                     oper=true;
                     num=false;
                     beq=false;
                     }
                }
                else{
                    if (bnum1){
                     txOp.setText(num1+"*");
                     last="times";
                     oper=true;
                     num=false;
                     beq=false;
                    }
                    else
                    JOptionPane.showMessageDialog(null, "Please enter a number first !"); 
                }
        }
                else
                {
                    if (bnum1){
                     txOp.setText(num1+"*");
                     last="times";
                     oper=true;
                     num=false;
                     beq=false;
                    }
                    else
                    JOptionPane.showMessageDialog(null, "Please enter a number first !");
                }
                break;// End of TIMES actionperformed
                
                
            case "divide":
                if (oper==false){
                  if(!del){
                    if (!beq){
                         if(!bnum1){
                             num1= Integer.parseInt(txNum.getText());
                             txOp.setText(txNum.getText()+ "/");
                             txNum.setText("");
                             last="divide";
                             oper=true;
                             num=false;
                             bnum1=true;
                         }
                         else{    
                             num2=Integer.parseInt(txNum.getText());
                             doIt(last);
                             num1=res;
                             txOp.setText(num1+"/");
                             txNum.setText("");
                             last="divide";
                             oper=true;
                             num=false;
                         }
                     }
                   else
                     {
                     txOp.setText(num1+"/");
                     last="divide";
                     oper=true;
                     num=false;
                     beq=false;
                     }
                }
                else
                {
                    if (bnum1){
                     txOp.setText(num1+"/");
                     last="divide";
                     oper=true;
                     num=false;
                     beq=false;
                    }
                    else
                    JOptionPane.showMessageDialog(null, "Please enter a number first !"); 
                }
        }
                else
                {
                    if (bnum1){
                     txOp.setText(num1+"/");
                     last="divide";
                     oper=true;
                     num=false;
                     beq=false;
                    }
                    else
                    JOptionPane.showMessageDialog(null, "Please enter a number first !");
                }
                break;// End of DIVIDE actionperformed
                
                
            case "equal":// Start of EQUAL actionperformed
                if(!bnum1||!bnum2){
                    JOptionPane.showMessageDialog(null, "Do an operation first !!!");
                }
                else{
                     num2=Integer.parseInt(txNum.getText());
                     doIt(last);
                     num1=res;
                     txOp.setText("");
                     txNum.setText("");
                     txRes.setText(res+"");
                     oper=false;
                     num=true;
                     beq=true;
                    }
                break;// End of EQUAL actionperformed
                
                
        }
        repaint();
    }
    public void doIt(String s){
    
        switch (s){
            case "add" : {res=num1+num2;break;}
            case "minus" : {res=num1-num2;break;}
            case "times" : {res=num1*num2;break;}
            case "divide" : {
                if (num2!=0)
                res=num1/num2;
                else
                JOptionPane.showMessageDialog(null, "Can't Divide to Zero !!!");
                break;}
            default : {JOptionPane.showMessageDialog(null,"Error!!!");}
        }
    }
}
