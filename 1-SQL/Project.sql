DROP TABLE Residential_Area;

------------ TABLE Residential_Area ------------
CREATE TABLE Residential_Area (
  Entities_Number    NUMBER,
  Building_Name      VARCHAR2(32),
  Building_Layers    NUMBER,
  Building_State     VARCHAR2(32),
  Building_Attribute VARCHAR2(32),
  Geometry           SDO_GEOMETRY
);

------------ INSERT Building ------------
INSERT INTO Residential_Area VALUES (
    ---- Entities_Number ---
    1,
    
    ---- Building_Name ---
    'A',
    
    ---- Building_Layers ---
    2,  
    
    ---- Building_State ---
    'Sold',  
    
    ---- Building_Attribute ---
    'Residential',
    
    ---- Building_Geometry---
    SDO_GEOMETRY(  
        2003,  -- 2D polygon  
        NULL, -- Coordinate System: Cartesian Coordinate
        NULL, -- Point (not used in this context)  
        SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (counterclockwise)
        SDO_ORDINATE_ARRAY(0,5, 25,5, 25,25, 0,25, 0,5)
  )
);

INSERT INTO Residential_Area VALUES (
    ---- Entities_Number ---
    1,
    
    ---- Building_Name ---
    'B',
    
    ---- Building_Layers ---
    10,  
    
    ---- Building_State ---
    'Sold',  
    
    ---- Building_Attribute ---
    'Residential',
    
    ---- Building_Geometry---
    SDO_GEOMETRY(  
        2003,  -- 2D polygon  
        NULL, -- Coordinate System: Cartesian Coordinate
        NULL, -- Point (not used in this context)  
        SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (counterclockwise)
        SDO_ORDINATE_ARRAY(225,5, 250,50, 225,50, 225,5)
  )
);


INSERT INTO Residential_Area VALUES (
    ---- Entities_Number ---
    1,
    
    ---- Building_Name ---
    'C',
    
    ---- Building_Layers ---
    8,  
    
    ---- Building_State ---
    'Sold',  
    
    ---- Building_Attribute ---
    'Residential',
    
    ---- Building_Geometry---
    SDO_GEOMETRY(  
        2003,  -- 2D polygon  
        NULL, -- Coordinate System: Cartesian Coordinate
        NULL, -- Point (not used in this context)  
        SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (counterclockwise)
        SDO_ORDINATE_ARRAY(275,25, 300,25, 300,50, 275, 25)
  )
);


INSERT INTO Residential_Area VALUES (
    ---- Entities_Number ---
    1,
    
    ---- Building_Name ---
    'D',
    
    ---- Building_Layers ---
    8,  
    
    ---- Building_State ---
    'Sold',  
    
    ---- Building_Attribute ---
    'Residential',
    
    ---- Building_Geometry---
    SDO_GEOMETRY(  
        2003,  -- 2D polygon  
        NULL, -- Coordinate System: Cartesian Coordinate
        NULL, -- Point (not used in this context)  
        SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- exterior polygon (counterclockwise)
        SDO_ORDINATE_ARRAY(400,100, 500,200, 450,250, 400, 100)
  )
);


INSERT INTO Residential_Area VALUES (
    ---- Entities_Number ---
    1,
    
    ---- Building_Name ---
    'E',
    
    ---- Building_Layers ---
    8,  
    
    ---- Building_State ---
    'Sold',  
    
    ---- Building_Attribute ---
    'Residential',
    
    ---- Building_Geometry---
    SDO_GEOMETRY(  
        2003,    
        NULL, 
        NULL,
        SDO_ELEM_INFO_ARRAY(1, 1003, 4), 
        SDO_ORDINATE_ARRAY(50,175, 50,225, 25,200)
  )
);


