package com.bridgelabz.census;

/**
 * @desc:Represents state census information including state name, population, and state code.
 */
class StateCensus {
    // Fields
    private String state;      
    private int population;     
    private String stateCode;   

    /**
     * @desc: Constructs a StateCensus object with the specified state, population, and state code.
     * @param state      The name of the state.
     * @param population The population of the state.
     * @param stateCode  The code representing the state.
     * @return: none
     */
    public StateCensus(String state, int population, String stateCode) {
        this.state = state;
        this.population = population;
        this.stateCode = stateCode;
    }

    // Getters and Setters
    /**
     * @desc: Gets the name of the state.
     * @params: none
     * @return The name of the state.
     */
    public String getState() {
        return state;
    }

    /**
     * @desc: Sets the name of the state.
     * @param state The name of the state.
     * @return: none
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @desc: Gets the population of the state.
     * @params: none
     * @return The population of the state.
     */
    public int getPopulation() {
        return population;
    }

    /**
     * @desc: Sets the population of the state.
     * @param population The population of the state.
     * @return none
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * @desc: Gets the state code.
     * @params: none
     * @return The state code.
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * @desc: Sets the state code.
     * @param stateCode The state code.
     * @return:none
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    // toString() method
    /**
     * @desc: Returns a string representation of the StateCensus object.
     * @params:none
     * @return A string representation of the StateCensus object.
     */
    @Override
    public String toString() {
        return "{" +
                "state='" + state + '\'' +
                ", population=" + population +
                ", state code='" + stateCode + '\'' +
                // Include other fields in the toString() method
                '}';
    }
}
