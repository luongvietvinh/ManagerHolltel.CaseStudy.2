package service;

import IO.WriteTofileReadFile;
import model.Bill;

import java.util.List;

public class BillService {

    private List<Bill> listBill = WriteTofileReadFile.readFileBill();


    public List<Bill> showListBill() {
        listBill = WriteTofileReadFile.readFileBill();
        for (Bill bl : listBill) {
            System.out.println( "\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+bl);
            System.out.println("                                    --------------------------------------------------------------------------------------");
        }
        return null;
    }

    public void addBill(Bill bill) {
        listBill.add(bill);
        WriteTofileReadFile.writeToFileBill(listBill);
    }


    public int searchBillById(int id) {
        listBill = WriteTofileReadFile.readFileBill();
        for (int i = 0; i < listBill.size(); i++) {
            if (id == listBill.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }


    public void deleteBill(int id) {
        listBill.remove(id);
        WriteTofileReadFile.writeToFileBill(listBill);
    }

}
