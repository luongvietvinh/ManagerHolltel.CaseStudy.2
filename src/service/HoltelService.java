package service;

import IO.WriteTofileReadFile;
import model.ServiceHoltel;

import java.util.List;

public class HoltelService {

   private List<ServiceHoltel> listDichVu = WriteTofileReadFile.readFileHoltelService();

    public List<ServiceHoltel> showlist(){
        for (ServiceHoltel dv: listDichVu) {
            System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+dv);
            System.out.println("                     ------------------------------------------------------------------------------------------------");
        }
        return listDichVu;
    }

    public void addListHoltelService(ServiceHoltel serviceHoltel){
        listDichVu.add(serviceHoltel);
        WriteTofileReadFile.writeToFileHoltelService(listDichVu);
    }

    public void editHoltelService(String name , ServiceHoltel serviceHoltel){
        listDichVu.set(findByName(name),serviceHoltel);
        WriteTofileReadFile.writeToFileHoltelService(listDichVu);

    }

    public void deleteByName(String name){
        listDichVu.remove(findByName(name));
        WriteTofileReadFile.writeToFileHoltelService(listDichVu);
    }

    public int findByName(String name){
        for (int i = 0; i <listDichVu.size() ; i++) {
            if (listDichVu.get(i).getNameService().equals(name)){
                return i;
            }
        }
        return -1;
    }

}
