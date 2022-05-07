// Simon Yoseph
// 4/12/22
// COSC 237 - 003

package currentRatesPackage;

public class TimeSpan {
        
    private char timeUnit;
    private int numUnits;

   // Constructor
  public TimeSpan (char tU, int nU){
      timeUnit = tU; // ‘D’ (day), ‘W’ (week), ‘M’ (month)
      numUnits = nU; // num of days, weeks or months
  }

  // Getter Methods
    public char getTimeUnit(){
      return timeUnit;
        }
        public int getNumUnits(){
       return numUnits;
        }
      
    public String getTimeSpan() {
      switch (this.timeUnit) {
        case 'D':
          return numUnits + " day(s)";
        case 'W':
          return numUnits + " week(s)";
        case 'M':
          return numUnits + " month(s)";
        default:
          return "No Timespan";
      }
    }
}