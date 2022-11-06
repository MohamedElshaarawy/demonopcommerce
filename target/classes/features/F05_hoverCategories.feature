@smoke
  Feature: hoverCategories
    Scenario:selecting catgeory
      Given user hover on random category
      And user select random subcategory
      Then assert the page title is same like subcatgory or category
