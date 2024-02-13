import java.io.*;
import java.util.*;

public class BlockSectionDA {
    private List<BlockSection> blockSectionList;

    //getter method
    public List<BlockSection> getBlockSectionList() {
        return blockSectionList;
    }

    //constructor
    public BlockSectionDA() throws FileNotFoundException {
        blockSectionList = new ArrayList<>();

        Scanner bsFile = new Scanner(new FileReader("blockSection.csv"));

        while(bsFile.hasNext()) {
            BlockSection bs = new BlockSection();

            String bsRaw = bsFile.nextLine();
            String[] bsArray = new String[3];
            bsArray = bsRaw.split(",");

            //set values
            bs.setBlockCode(bsArray[0].trim());
            bs.setDescription(bsArray[1].trim());
            bs.setAdviser(bsArray[2].trim());

            StudentDA studentDA = new StudentDA(bs.getBlockCode());
            bs.setStudentList(studentDA.getStudentList());

            blockSectionList.add(bs);
        }
        bsFile.close();
    }
}