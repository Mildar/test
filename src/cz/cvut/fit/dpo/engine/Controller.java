/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.dpo.engine;

import cz.cvut.fit.dpo.engine.model.commands.CommandInterface;
import cz.cvut.fit.dpo.engine.model.Game;
import cz.cvut.fit.dpo.engine.model.Room;
import cz.cvut.fit.dpo.engine.model.commands.GetCommand;
import cz.cvut.fit.dpo.engine.model.commands.UndefinedCommand;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hanz
 */
public class Controller {
    
        private View viewGame;
        private Game modelGame;
        private CommandInterface actualCommand;
        private File file = new File("gameData_1");
        private List<CommandInterface> commandList;
        
        public void executeControllLoop() throws FileNotFoundException, IOException{
            Scanner sc = new Scanner(System.in);
            String inputLine;
            String returnMessage;
            while(true){
                inputLine = sc.nextLine();
                actualCommand = createCommand(inputLine);
                returnMessage = modelGame.proccedCommand(actualCommand);
                viewGame.displayMessage(returnMessage);
            }
        }

    //vyhleda command ze seznamu a nastavi mu argumenty. jinak posila UndefinedCommand
    public CommandInterface createCommand(String inputLine) {
        System.out.println(inputLine);
        if(inputLine.trim() == null){
            return new UndefinedCommand();
        }
        String[] commandArguments = inputLine.split(" ", 4); // 4 protože máme max čtyř slový příkaz :-)
            for(CommandInterface command : commandList){
                if(command.getCommandType().equalsIgnoreCase(commandArguments[0])){
                    String [] arguments = Arrays.copyOfRange(commandArguments, 1, commandArguments.length);
                    command.setCommandArguments(arguments);
                    return command;
                }                
            }
        
        return new UndefinedCommand();
    }

    private Game initGame() throws FileNotFoundException, IOException { // můžem mu dát třeba parametr z příkazovky, tady to bude staticky
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr); // dodáme try catch finally
        String line;
        ArrayList<Room> tempList = new ArrayList<>();
        
        while((line = br.readLine()) != null){
            //tady naparsovat vstup Room ze souboru a list předat kontruktoru Room
            
         
        }
        
        return null;
    }

    public Controller() {
        try {
            viewGame = new View();
            modelGame = initGame();
            populateCommands();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void populateCommands(){
        commandList = new ArrayList();
        commandList.add(new UndefinedCommand());
        commandList.add(new GetCommand());
    }
}
